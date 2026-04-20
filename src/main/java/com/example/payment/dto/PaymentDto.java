package com.example.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentDto(
        UUID id,
        BigDecimal amount,
        String currency,
        String paymentMethod,
        LocalDateTime createdAt
) {
}
