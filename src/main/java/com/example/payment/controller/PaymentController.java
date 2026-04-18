package com.example.payment.controller;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/execute")
    public String execute(@RequestBody PaymentRequest request) {
        return paymentService.pay(String.valueOf(request.type()), request.amount());
    }
}
