package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.CarDetails;

@Repository
public interface CarDetailsRepository extends MongoRepository<CarDetails,String> {
}
