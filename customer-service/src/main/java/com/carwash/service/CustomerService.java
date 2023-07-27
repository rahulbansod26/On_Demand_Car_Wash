package com.carwash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carwash.model.CarDetails;
import com.carwash.model.Customer;
import com.carwash.model.Orders;
import com.carwash.model.RatingsAndReview;

@Service
public interface CustomerService {
	
	public Customer findByUsername(String username);

	public List<Customer> getAllCustomers();

	public Customer findById(int id);

	public Customer addCustomer(Customer customer);

	public List<Customer> findByRole(String role);

	public Customer updateProfile(Customer customer, String username);

	public RatingsAndReview giveRatingAndReview(RatingsAndReview ratingReview);

	public CarDetails addCarDetails(CarDetails carDetails);

	public List<Orders> customerOrders(String name);
}
	



























//public void addCardetail(CarDetails carDetails) {
//	customerRepository.save(carDetails);		
//}
//
//public CarDetails updateCardetail(CarDetails carDetails) {
//	return customerRepository.save(carDetails);
//}










