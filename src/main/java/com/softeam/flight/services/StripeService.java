package com.softeam.flight.services;

import java.util.Map;

import com.softeam.flight.entities.ChargeRequest;
import com.stripe.exception.StripeException;

public interface StripeService {
	
	public Map<String, Object> getPublicKey();
	
	public String createPaymentIntent(final ChargeRequest chargeRequest) throws StripeException;

}
