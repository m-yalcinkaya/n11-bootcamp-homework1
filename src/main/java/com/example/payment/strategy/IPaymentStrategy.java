package com.example.payment.strategy;

import java.math.BigDecimal;

public interface IPaymentStrategy{
    String getType();

    default String process(BigDecimal amount) {
        return amount + " TL " + getType() + " ile ödendi.";
    }
}
