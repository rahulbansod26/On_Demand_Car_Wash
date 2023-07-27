package com.customer.repository;

import com.customer.model.CarDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailsRepository extends MongoRepository<CarDetails,String> {
}
