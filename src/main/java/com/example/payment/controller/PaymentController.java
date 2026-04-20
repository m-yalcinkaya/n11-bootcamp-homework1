package com.example.payment.controller;

import com.example.payment.dto.CreatePaymentRequest;
import com.example.payment.dto.PaymentDto;
import com.example.payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@Valid @RequestBody CreatePaymentRequest request) {
        return new ResponseEntity<>(paymentService.pay(request), HttpStatus.OK);
    }

    @GetMapping("All")
    public ResponseEntity<List<PaymentDto>> getAllPayments(){
        return new ResponseEntity<>(paymentService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deletePayment(@PathVariable UUID id){
            paymentService.deletePayment(id);
            return new ResponseEntity<>("Deleted Payment: " + id,HttpStatus.OK);
        }
    }

