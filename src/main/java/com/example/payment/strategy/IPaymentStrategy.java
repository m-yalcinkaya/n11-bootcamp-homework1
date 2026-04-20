package com.example.payment.strategy;

public interface IPaymentStrategy{
    String getType();
    public String process(int amount);
}
