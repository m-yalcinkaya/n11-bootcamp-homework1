package com.example.payment.strategy;



public class CreditCardStrategy implements IPaymentStrategy {

    @Override
    public String getType() {
        return "CreditCard";
    }

}
