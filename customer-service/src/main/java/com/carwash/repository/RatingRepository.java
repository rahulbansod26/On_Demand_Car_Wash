package com.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.carwash.model.RatingsAndReview;

@Repository
public interface RatingRepository extends MongoRepository<RatingsAndReview,Integer> {

}
