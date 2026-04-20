package com.example.payment.strategy;

public interface IPaymentStrategy{
    String getType();

    default String process(int amount) {
        return amount + " TL " + getType() + " ile ödendi.";
    }
}
