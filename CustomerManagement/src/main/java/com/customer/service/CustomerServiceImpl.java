package com.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.customer.exceptions.CustomerNotFoundException;
import com.customer.exceptions.userNameAlreadyExists;
import com.customer.model.CarDetails;
import com.customer.model.Customer;
import com.customer.model.Order;
import com.customer.model.RatingReview;
import com.customer.repository.CarDetailsRepository;
import com.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CarDetailsRepository carDetailsRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Customer findByUsername(String username) {
		Customer customer = customerRepository
                .findAll()
                .stream()
                .filter(a -> a.getUsername().equalsIgnoreCase(username))
                .findAny().orElse(null);
		if (customer == null) {
			throw new CustomerNotFoundException("Sorry, Customer with the provided Username not found" +
					",Please provide the correct Username");
		}
		else {
			return customerRepository.findByUsername(username);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {

		customer.setProfile("default.png");
		customer.setRole("Customer");
		Customer customer1 = this.customerRepository.findByUsername(customer.getUsername());
		if (customer1 != null) {
			System.out.println("Customer is already there !!");
			throw new userNameAlreadyExists("Username already present!!!");

		}
		else {
		System.out.println(customer);
		return customerRepository.save(customer);
		}
	}

	@Override
	public List<Customer> findByRole(String role) {
		return customerRepository.findAll().stream().filter(a -> a.getRole().equalsIgnoreCase(role)).collect(Collectors.toList());
	}

	@Override
	public Customer updateProfile(Customer customer, String username) {
		Customer existingCustomer = customerRepository.findByUsername(username);

		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setName(customer.getName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());
		existingCustomer.setRole(customer.getRole());
		customerRepository.save(existingCustomer);

		return existingCustomer;
	}

	@Override
	public RatingReview giveRatingAndReview(RatingReview ratingReview) {
		return null;
	}

	@Override
	public CarDetails addCarDetails(CarDetails carDetails) {
		return carDetailsRepository.save(carDetails);
	}

	@Override
	public List<Order> customerOrders(String name) {
		List<Order> orderList = null;

		try {
			ResponseEntity<List<Order>> claimResponse = restTemplate.exchange(
					"http://localhost:9003/order/get-orders/" + name,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<Order>>() {
					});
			if (claimResponse.hasBody()) {
				orderList = claimResponse.getBody();
			}
		} catch (RestClientException e) {
			e.printStackTrace();
		}

		return orderList;
	}


}
