package com.example.payment.strategy;

public class ApplePayStrategy implements IPaymentStrategy{
    @Override
    public String getType() {
        return "ApplePay";
    }
}
