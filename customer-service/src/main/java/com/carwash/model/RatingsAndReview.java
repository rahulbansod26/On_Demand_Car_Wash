package com.carwash.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ratings")
public class RatingsAndReview {
	
	@NotEmpty(message="please provide a rating")
	private int rating;
	private String comment;
	
	
	//default constructor
	public RatingsAndReview() {
		
	}

	//constructor
	public RatingsAndReview( @NotEmpty(message = "please provide a rating") int rating,
			String comment) {
		super();
		this.rating = rating;
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
	
	
	