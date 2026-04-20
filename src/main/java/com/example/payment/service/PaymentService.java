package com.example.payment.service;

import com.example.payment.strategy.IPaymentStrategy;
import org.springframework.stereotype.Service;



@Service
public class PaymentService {

    public String pay(String type, int amount) {
        try {
            IPaymentStrategy strategy = PaymentFactory.createPaymentMethod(type);

            return strategy.process(amount);

        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Sistem hatası: Ödeme gerçekleştirilemedi.";
        }
    }
}