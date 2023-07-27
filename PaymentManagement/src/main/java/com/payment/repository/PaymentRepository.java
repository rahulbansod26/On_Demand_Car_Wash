package com.payment.repository;

import com.mongodb.client.MongoDatabase;
import com.payment.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment,Integer> {

    @Override
    List<Payment> findAll();
}
