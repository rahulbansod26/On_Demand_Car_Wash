package com.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payment.model.Payment;
import com.payment.model.TransactionRequest;
import com.payment.model.TransactionResponse;

import java.util.List;
import java.util.Optional;

public interface PaymentService {


    public List<Payment> paymentList(String name) ;

    public Optional<Payment> paymentById(int id) throws JsonProcessingException;

    public TransactionResponse doPaymentSetOrderPaymentStatus(TransactionRequest request) throws JsonProcessingException;

    public String paymentProcessing();


}
