package com.softeam.flight.entities;

import com.softeam.flight.enums.Currency;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ChargeRequest.
 */

@Data
public class ChargeRequest {
    
    /** The amount. */
    private Long amount;
    
    /** The currency. */
    private String currency;
    
    /** The payment method. */
    private String paymentMethod;
    
    /** The description. */
    private String description;
    
    /** The stripe email. */
    private String stripeEmail;
    
    /** The stripe token. */
    private String stripeToken;
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the payment method.
	 *
	 * @return the payment method
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the payment method.
	 *
	 * @param paymentMethod the new payment method
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Gets the stripe email.
	 *
	 * @return the stripe email
	 */
	public String getStripeEmail() {
		return stripeEmail;
	}
	
	/**
	 * Sets the stripe email.
	 *
	 * @param stripeEmail the new stripe email
	 */
	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}
	
	/**
	 * Gets the stripe token.
	 *
	 * @return the stripe token
	 */
	public String getStripeToken() {
		return stripeToken;
	}
	
	/**
	 * Sets the stripe token.
	 *
	 * @param stripeToken the new stripe token
	 */
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
}
