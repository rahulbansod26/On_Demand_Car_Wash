package com.carwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer>{
	
	
	public List<Customer> findAll();

	public Customer findById(int id);
    
    public Customer findByUsername(String username);

 	public List<Customer> findByRole(String role);

}
