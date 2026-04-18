package com.example.payment.strategy;

import com.example.payment.constants.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class EFTStrategy implements IPaymentStrategy{
    @Override
    public PaymentType getType() {
        return PaymentType.EFT;
    }

    @Override
    public String process(int amount) {
        return amount + " TL EFT ile ödendi.";
    }
}
