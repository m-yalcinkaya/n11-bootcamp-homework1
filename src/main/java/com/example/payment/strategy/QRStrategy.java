package com.example.payment.strategy;



public class QRStrategy implements IPaymentStrategy{
    @Override
    public String getType() {
        return "QR";
    }
}
