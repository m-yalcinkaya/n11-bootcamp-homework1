package com.example.payment.strategy;


public class EFTStrategy implements IPaymentStrategy{
    @Override
    public String getType() {
        return "EFT";
    }

    @Override
    public String process(int amount) {
        return amount + " TL " + getType() + " ile ödendi.";
    }
}
