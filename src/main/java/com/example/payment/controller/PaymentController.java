package com.example.payment.controller;

import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.PaymentRequest;
import com.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public String pay(@RequestBody PaymentRequest request) {
        return paymentService.pay(request);
    }

    @GetMapping("All")
    public List<PaymentDto> getAllPayments(){
        return paymentService.getAll();
    }
}
