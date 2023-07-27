package com.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.model.Order;
import com.payment.model.Payment;
import com.payment.model.TransactionRequest;
import com.payment.model.TransactionResponse;
import com.payment.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository paymentRepository;

    Random random = new Random();

    @Override
    public List<Payment> paymentList(String name) {
        return paymentRepository.findAll()
                .stream().filter(payment -> payment.getCustomerName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Payment> paymentById(int id) throws JsonProcessingException {
        Optional<Payment> payment = paymentRepository.findById(id);
        log.info("Payment-Service List of Payments: {}", new ObjectMapper().writeValueAsString(payment));
        return payment;
    }

    @Override
    public TransactionResponse doPaymentSetOrderPaymentStatus(TransactionRequest request) throws JsonProcessingException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy/HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        dtf.format(currentTime);
        Payment payment = request.getPayment();
        Order order = request.getOrder();
        payment.setPaymentId(random.nextInt(9999));
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentDate(currentTime);

        log.info("Payment-Service Request: {}", new ObjectMapper().writeValueAsString(payment));

//        if (payment.getPaymentStatus().equalsIgnoreCase("success")) {
//            order.setPaymentStatus("Paid");
//            restTemplate.postForObject("http://order-microservice/order/update-status", order, Order.class);
//            paymentRepository.save(payment);
//            sendEmail(payment, order.getEmailAddress());
//            return new TransactionResponse(order, payment.getTransactionId(), payment.getAmount(), "Payment Successful");
//        } else {
//            sendEmail(payment, order.getEmailAddress());
//            return new TransactionResponse(order, payment.getTransactionId(), payment.getAmount(), "Payment Failed Please try again!");
//        }
        return null;
    }

    @Override
    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "payment failed, please try again !";
    }
}
