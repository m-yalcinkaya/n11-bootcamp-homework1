package com.example.payment.service;

import com.example.payment.constants.PaymentType;
import com.example.payment.strategy.IPaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final Map<PaymentType, IPaymentStrategy> strategyMap;

    public PaymentService(List<IPaymentStrategy> strategies) {
        strategyMap = strategies.stream()
                .collect(Collectors.toMap(IPaymentStrategy::getType, s -> s));
    }

    public String pay(String type, int amount) {
        try {
            PaymentType paymentType = PaymentType.valueOf(type.toUpperCase());
            IPaymentStrategy strategy = strategyMap.get(paymentType);
            return (strategy != null) ? strategy.process(amount) : "Yöntem bulunamadı!";
        } catch (IllegalArgumentException e) {
            return "Geçersiz ödeme yöntemi: " + type;
        }
    }

}
