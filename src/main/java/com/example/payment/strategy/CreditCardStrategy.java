package com.example.payment.strategy;

import com.example.payment.constants.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class CreditCardStrategy implements IPaymentStrategy {

    @Override
    public PaymentType getType() {
        return PaymentType.CREDIT_CARD;
    }

    @Override
    public String process(int amount) {
        return amount + " TL Kredi Kartı ile ödendi.";
    }
}
