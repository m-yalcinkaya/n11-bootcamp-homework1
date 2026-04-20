package com.example.payment.service;

import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.converter.PaymentDtoConverter;
import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;
import com.example.payment.strategy.IPaymentStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentDtoConverter paymentDtoConverter;

    public PaymentService(PaymentRepository paymentRepository, PaymentDtoConverter paymentDtoConverter) {
        this.paymentRepository = paymentRepository;
        this.paymentDtoConverter = paymentDtoConverter;
    }

    public String pay(PaymentRequest request) {
        try {
            Payment payment = Payment.builder()
                    .amount(request.amount())
                    .paymentMethod(request.type())
                    .currency("TL")
                    .createdAt(LocalDateTime.now())
                    .build();

            paymentRepository.save(payment);

            IPaymentStrategy strategy = PaymentFactory.createPaymentMethod(request.type());

            return strategy.process(request.amount());



        } catch (Exception e) {
            return "Sistem hatası: Ödeme gerçekleştirilemedi.";
        }
    }

    public List<PaymentDto> getAll() {
        return paymentRepository.findAll().
                stream().
                map(paymentDtoConverter::convertPaymentDto).
                collect(Collectors.toList());
    }
}