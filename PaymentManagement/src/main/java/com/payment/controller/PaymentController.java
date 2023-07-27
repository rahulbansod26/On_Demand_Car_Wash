package com.payment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payment.model.Payment;
import com.payment.model.TransactionRequest;
import com.payment.model.TransactionResponse;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/pay")
    public TransactionResponse payAmount(@RequestBody TransactionRequest request) throws JsonProcessingException {
        return paymentService.doPaymentSetOrderPaymentStatus(request);
    }

    @GetMapping("/get-payments-list")
    public ResponseEntity<List<Payment>> paymentList() {
        return new ResponseEntity<>(paymentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-payment/{name}")
    public List<Payment> paymentListOfName(@PathVariable String name) {
        return paymentService.paymentList(name);
    }
}
