package com.example.payment.controller;

import com.example.payment.dto.CreatePaymentRequest;
import com.example.payment.dto.PaymentDto;
import com.example.payment.service.CreatePaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final CreatePaymentService createPaymentService;

    public PaymentController(CreatePaymentService createPaymentService) {
        this.createPaymentService = createPaymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@Valid @RequestBody CreatePaymentRequest request) {
        return new ResponseEntity<>(createPaymentService.pay(request), HttpStatus.OK);
    }

    @GetMapping("All")
    public ResponseEntity<List<PaymentDto>> getAllPayments(){
        return new ResponseEntity<>(createPaymentService.getAll(), HttpStatus.OK);
    }
}
