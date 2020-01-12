package com.softeam.stripe.services.impl;

import com.google.gson.annotations.SerializedName;

public class ProductDetails {
	@SerializedName("amount")
    Long amount;

    @SerializedName("currency")
    String currency;

    public String getCurrency() {
        return currency;
    }

    public Long getAmount() {
        return amount;
    }
}
