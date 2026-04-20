package com.example.payment.strategy;

public class GooglePayStrategy implements  IPaymentStrategy{
    @Override
    public String getType() {
        return "GooglePay";
    }

    @Override
    public String process(int amount) {
        return amount + " TL " + getType() + " ile ödendi.";
    }
}
