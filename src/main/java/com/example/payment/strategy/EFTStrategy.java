package com.example.payment.strategy;


public class EFTStrategy implements IPaymentStrategy{
    @Override
    public String getType() {
        return "EFT";
    }


}
