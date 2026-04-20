package com.example.payment.service;

import com.example.payment.strategy.IPaymentStrategy;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;


@Service
public class PaymentService {

    public String pay(String type, int amount) {
        try {
             Class<?> clazz = Class.forName("com.example.payment.strategy." + type + "Strategy");
            IPaymentStrategy strategy = (IPaymentStrategy) clazz.getDeclaredConstructor().newInstance();
            return strategy.process(amount);
        } catch (IllegalArgumentException e) {
            return "Geçersiz ödeme yöntemi: " + type;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
