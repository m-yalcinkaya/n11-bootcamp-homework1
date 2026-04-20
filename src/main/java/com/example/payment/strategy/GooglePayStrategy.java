package com.example.payment.strategy;

public class GooglePayStrategy implements  IPaymentStrategy{
    @Override
    public String getType() {
        return "GooglePay";
    }


}
