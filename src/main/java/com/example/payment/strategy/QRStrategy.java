package com.example.payment.strategy;

import com.example.payment.constants.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class QRStrategy implements IPaymentStrategy{
    @Override
    public PaymentType getType() {
        return PaymentType.QR;
    }

    @Override
    public String process(int amount) {
        return amount + " TL QR ile ödendi.";
    }
}
