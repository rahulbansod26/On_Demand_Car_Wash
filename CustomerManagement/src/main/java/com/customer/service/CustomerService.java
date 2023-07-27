package com.customer.service;

import com.customer.model.CarDetails;
import com.customer.model.Customer;
import com.customer.model.Order;
import com.customer.model.RatingReview;

import java.util.List;

public interface CustomerService {

	public Customer findByUsername(String username);

	public List<Customer> getAllCustomers();

	public Customer findById(int id);

	public Customer addCustomer(Customer customer);

	public List<Customer> findByRole(String role);

	public Customer updateProfile(Customer customer, String username);

	public RatingReview giveRatingAndReview(RatingReview ratingReview);

	public CarDetails addCarDetails(CarDetails carDetails);

	public List<Order> customerOrders(String name);

}
