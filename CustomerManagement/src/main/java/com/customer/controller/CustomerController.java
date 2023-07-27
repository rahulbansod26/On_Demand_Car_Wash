package com.customer.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import com.customer.filter.JwtFilter;
import com.customer.model.*;
import com.customer.repository.CustomerRepository;
import com.customer.service.MyUserDetailsService;
import com.customer.service.SequenceGeneratorService;
import com.customer.util.JwtUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.customer.service.CustomerServiceImpl;
import com.customer.utilities.GlobalResources;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	private Logger logger = GlobalResources.getLogger(CustomerController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private SequenceGeneratorService service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private JwtFilter jwtFilter;


    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		String methodName = "(addCustomer)";

		try {
			logger.info(methodName + "Called");
			System.out.println(customer);
			customer.setId(service.getSequenceNumber(Customer.SEQUENCE_NAME));
			customerService.addCustomer(customer);
			return ResponseEntity.ok(customer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(methodName,"Something went wrong!!!!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	 @GetMapping("/get-customer/{username}")
	    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable("username") String username) {

		String methodName = "getCustomerByUsername()";

		 try {
	    		logger.info(methodName + "Called");
	            Customer customer = customerService.findByUsername(username);
	            return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
				logger.error(methodName,"Something went wrong!!!!");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	@GetMapping("/customer-id/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id)
	{
		String methodName = "getCustomerById()";

		try {
			logger.info(methodName + "Called");
			Customer customer = customerService.findById(id);
			return ResponseEntity.of(Optional.of(customer));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(methodName,"Something went wrong!!!!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/get-all-customer")
    	public ResponseEntity<List<Customer>> getAllCustomer() {

		String methodName = "getAllCustomer()";

		try {
			logger.info(methodName + "Called");
			List<Customer> list = customerService.getAllCustomers();
			return ResponseEntity.ok().body(list);
		}
		catch (Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/update-profile/{username}")
	public ResponseEntity<Customer> updateProfile(@PathVariable("username") String username,
												  @RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.updateProfile(customer, username), HttpStatus.OK);
	}

	@GetMapping("/get-customer-role/{role}")
	public List<Customer> getCustomerByRole(@PathVariable("role") String role){
		return customerService.findByRole(role);
	}

	@PostMapping("/car-details")
	public ResponseEntity<CarDetails> addCarDetails(@RequestBody CarDetails carDetails)
	{
		String methodName = "(addCarDetails)";

		try {
			logger.info(methodName + "Called");
			System.out.println(carDetails);
			customerService.addCarDetails(carDetails);
			return ResponseEntity.ok(carDetails);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(methodName,"Something went wrong!!!!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	//SECURITY REST APIS

	@PostMapping("/authenticate") // Authenticate a Customer (Existing)
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid Username or Password!",e);
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}


//	@GetMapping("/current-user")
//	public Object getCurrentUser(Authentication authentication){
//		return authentication.getPrincipal();
//	}
	@GetMapping("/current-user")
	public Object getCurrentUser(Authentication authentication){
		return authentication.getPrincipal();
	}
	@GetMapping("/allpacks")
	public List<Washpacks> getWashpacks()
	{
		String baseurl = "http://localhost:9001/admin/get-all";
		Washpacks[] washpacks = restTemplate.getForObject(baseurl,Washpacks[].class);
		return Arrays.asList(washpacks);
	}

	@GetMapping("/my-orders")
	public List<Order> myOrders() {
		return customerService.customerOrders(jwtFilter.getLoggedInUserName());
	}
}
