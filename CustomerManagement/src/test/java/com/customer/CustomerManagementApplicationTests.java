package com.customer;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.customer.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class CustomerManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	@MockBean
	private CustomerServiceImpl customerService;

	@Autowired
	private CustomerRepository customerRepository;


	@Test
	public void addCustomer() {
		Customer customer = new Customer(1,"Mason","ms123","Mason Jones","mj5@gmail.com","9999999999",
				"grand Avenue,Boston",true,"default.png","Customer");
		when(customerService.addCustomer(customer)).thenReturn(customer);
		assertEquals(customer,customerService.addCustomer(customer));
	}


	@Test
	public void getCustomerByUsername(){

		Customer customer = new Customer(1,"Mason","ms123","Mason Jones","mj5@gmail.com","9999999999",
				"grand Avenue,Boston",true,"default.png","Customer");
		when(customerService.findByUsername("Mason")).thenReturn(customer);
	}



}
