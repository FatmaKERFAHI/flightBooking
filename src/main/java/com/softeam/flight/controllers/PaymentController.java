package com.softeam.flight.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.softeam.flight.entities.ChargeRequest;
import com.softeam.flight.services.StripeService;
import com.stripe.exception.StripeException;

@CrossOrigin
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	
	
	@Autowired
	private StripeService stripeService;
	
	@GetMapping(value = "/public-key", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getPublicKey() {
        return new ResponseEntity<Object>(stripeService.getPublicKey(), HttpStatus.OK) ;
	}

	@PostMapping(value= "/create-payment-intent")
	public ResponseEntity<Object> createPaymentIntent(@RequestBody ChargeRequest chargeRequest) {
		String intent = null;
		try {
			intent = stripeService.createPaymentIntent(chargeRequest);
		} catch (StripeException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Object>(intent, HttpStatus.OK) ;

	}
	
	
}
