package com.softeam.stripe.services.impl;

import com.google.gson.annotations.SerializedName;

public class CreatePaymentBody {

	 @SerializedName("payment_method_types")
     String payment_method_types;
	 
	   public String getPaymentMethod() {
           return payment_method_types;
       }
	
}
