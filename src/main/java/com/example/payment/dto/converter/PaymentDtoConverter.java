package com.example.payment.dto.converter;

import com.example.payment.dto.PaymentDto;
import com.example.payment.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentDtoConverter {
    public PaymentDto convertPaymentDto(Payment payment){
        return new PaymentDto(payment.getId(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getPaymentMethod(),
                payment.getCreatedAt());
    }
}
