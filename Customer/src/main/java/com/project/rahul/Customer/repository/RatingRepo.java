package com.project.rahul.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.rahul.Customer.model.Ratings;
@Repository
public interface RatingRepo extends MongoRepository<Ratings,String>{

}
