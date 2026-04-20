package com.example.payment.service;

import com.example.payment.strategy.IPaymentStrategy;
import org.springframework.stereotype.Service;


@Service
public class PaymentFactory {

    public static IPaymentStrategy createPaymentMethod(String type) {
        try {
            String className = "com.example.payment.strategy." + type + "Strategy";

            Class<?> clazz = Class.forName(className);
            return (IPaymentStrategy) clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            throw new IllegalArgumentException("Geçersiz ödeme yöntemi: " + type);
        }
    }
}
