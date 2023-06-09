package com.project.rahul.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.rahul.Customer.model.customerDetails;

@Repository
public interface CustomerRepo extends MongoRepository<customerDetails, String> {

}
