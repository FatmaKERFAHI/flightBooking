package com.softeam.stripe.services.impl;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class StripeServiceImpl {

	private Gson gson = new Gson();
	@Value("${stripe.publishable.key}")
	private String stripePublishableKey;
	@Value("${stripe.secret.key}")
	private String stripeSecretKey;
	
	@PostConstruct
	  public void init(){
		port(4242);
        Stripe.apiKey = stripeSecretKey;
	  }
	
	public void checkApi() {
        get("/", (request, response) -> {
            response.type("application/json");
            return "Hello from API";
        });
	}
	
	public void getPublicKey( ) {
		get("/public-key", (request, response) -> {
            response.type("application/json");

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("publicKey", stripePublishableKey);
            return gson.toJson(responseData);
        });
	}
	
	public String getProductDetail() {
		 get("/product-details", (request, response) -> {
	            response.type("application/json");

	            ProductDetails productDetails = getProductDetails();
	            return gson.toJson(productDetails);
	        });
		return null;
	}
	
	public void createPaymentIntent( ) {
		   post("/create-payment-intent", (request, response) -> {
	            response.type("application/json");

	            ProductDetails productDetails = getProductDetails();
	            CreatePaymentBody postBody = gson.fromJson(request.body(), CreatePaymentBody.class);

	            PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
	                    .setCurrency(productDetails.getCurrency()).setAmount(productDetails.getAmount())
	                    .setPaymentMethod(postBody.getPaymentMethod()).build();

	            PaymentIntent intent = PaymentIntent.create(createParams);

	            return gson.toJson(intent);
	        });
	}
	
	public void webHook() {
		post("/webhook", (request, response) -> {
            System.out.println("Webhook");
            String payload = request.body();
            String sigHeader = request.headers("Stripe-Signature");
            String endpointSecret = System.getenv("STRIPE_WEBHOOK_SECRET");

            Event event = null;

            try {
                event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
            } catch (SignatureVerificationException e) {
                // Invalid signature
                response.status(400);
                return "";
            }

            switch (event.getType()) {
            case "payment_intent.succeeded":
                // Fulfill any orders, e-mail receipts, etc
                System.out.println("💰 Payment received!");
                break;
            case "payment_intent.payment_failed":
                // Notify the customer that their order was not fulfilled
                System.out.println("❌ Payment failed.");
                break;
            default:
                // Unexpected event type
                response.status(400);
                return "";
            }

            response.status(200);
            return "";
        });
	}
	
	  private ProductDetails getProductDetails() {
	        ProductDetails details = new ProductDetails();
	        details.amount = (long) 9900;
	        details.currency = "EUR";

	        return details;
	    }
}
