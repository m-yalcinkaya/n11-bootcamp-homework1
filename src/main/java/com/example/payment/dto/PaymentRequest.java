package com.example.payment.dto;


public record PaymentRequest(
        int amount,
        String type
) {
}
