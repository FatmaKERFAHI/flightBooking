package com.softeam.flight.services.impl;

import static spark.Spark.post;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.ChargeRequest;
import com.softeam.flight.services.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;

@Service
public class StripeServiceImpl implements StripeService{

	@Value("${stripe.publishable.key}")
	private String stripePublishableKey;
	
	@Value("${stripe.secret.key}")
	private String stripeSecretKey;
	
	@PostConstruct
	public void init(){
		Stripe.apiKey = stripeSecretKey;
	}
	

	public Map<String, Object> getPublicKey() {
		 Map<String, Object> responseData = new HashMap<>();
		 responseData.put("publicKey", stripePublishableKey);
		return responseData;
	}
	
	public String createPaymentIntent(final ChargeRequest chargeRequest) throws StripeException {

//	    PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
//	            .setCurrency(chargeRequest.getCurrency().name()).setAmount(chargeRequest.getAmount())
//	            .setPaymentMethod(chargeRequest.getPaymentMethod()).build();
		
		Map<String, Object> createParams = new HashMap<String, Object>();
		createParams.put("amount", chargeRequest.getAmount());
		createParams.put("currency", chargeRequest.getCurrency());
		createParams.put("payment_method_types", Arrays.asList("card"));
	
	    PaymentIntent intent = PaymentIntent.create(createParams);
	
	    return intent.toJson();
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
}
