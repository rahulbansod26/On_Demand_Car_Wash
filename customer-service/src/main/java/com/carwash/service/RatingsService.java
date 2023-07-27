package com.carwash.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.RatingsAndReview;
import com.carwash.repository.RatingRepository;

@Service
public class RatingsService {
	
	@Autowired
	public RatingRepository ratingRepository;
	
	public List<RatingsAndReview> getAllRatings() {
		return ratingRepository.findAll();
	}

	public void addRatings(RatingsAndReview ratings) {
		System.out.println(ratings);
		ratingRepository.save(ratings);

	}

}
