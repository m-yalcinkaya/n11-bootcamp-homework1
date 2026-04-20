package com.example.payment.strategy;



public class CreditCardStrategy implements IPaymentStrategy {

    @Override
    public String getType() {
        return "CreditCard";
    }

    @Override
    public String process(int amount) {
        return amount + " TL Kredi Kartı ile ödendi.";
    }
}
