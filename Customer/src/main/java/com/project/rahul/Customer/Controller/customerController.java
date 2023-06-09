package com.project.rahul.Customer.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rahul.Customer.Service.CustomerService;
import com.project.rahul.Customer.Service.RatingsService;
import com.project.rahul.Customer.model.Ratings;
import com.project.rahul.Customer.model.customerDetails;
import com.project.rahul.Customer.repository.CustomerRepo;



@RestController
@RequestMapping("/users")
public class customerController {
	@Autowired
	private CustomerRepo customerrepo;
	@Autowired
	private RatingsService ratingservice;
	@Autowired
	private CustomerService customerservice;

	
	@PostMapping("/addRating")
    public Ratings addRating(@RequestBody Ratings ratings){
        return ratingservice.addRating(ratings);
    }
	@GetMapping("/getallRatings")
    public List<Ratings> getallratings(){
        return ratingservice.getallRatings();
    }
	@GetMapping("/washerSpecificRating/{washerName}")
    public List<Ratings> washerSpecificRating(@PathVariable String washerName){
        return ratingservice.washerSpecific(washerName);
	}
    @PostMapping("/addDetails")
    public customerDetails addDetails(@RequestBody customerDetails details)
    {
    	return customerservice.addDetails(details);
    }
    @PutMapping("/update/{Id}")
    public ResponseEntity updateDetails(@PathVariable String Id ,@RequestBody customerDetails details)
    {
    	customerservice.updateDetails(details);
    	return ResponseEntity.ok().build();
    }
    
    //delete the 
    @DeleteMapping("/delete/{id}")
    public void deleteproduct(@PathVariable String id)
    {
        customerrepo.deleteById(id);

    }
    //
    @GetMapping("/{id}")
    public List<customerDetails> customerSpecific(@PathVariable String id){
        return customerservice.CustomerSpecific(id);
	}

    }

