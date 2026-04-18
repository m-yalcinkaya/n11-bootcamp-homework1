package com.example.payment.strategy;

import com.example.payment.constants.PaymentType;

public interface IPaymentStrategy {

    PaymentType getType();
    String process(int amount);
}
