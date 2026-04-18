package com.example.payment.dto;

import com.example.payment.constants.PaymentType;

public record PaymentRequest(
        int amount,
        PaymentType type
) {
}
