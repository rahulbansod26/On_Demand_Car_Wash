package com.carwash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.carwash.controller.Customercontroller;
import com.carwash.model.CarDetails;
import com.carwash.model.Customer;
import com.carwash.repository.CustomerRepository;
import com.carwash.service.CustomerServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class CustomerServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	@MockBean
	private CustomerServiceImpl customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private Customercontroller customerController;

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

//	@Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        customerController = new Customercontroller(customerService);
//    }

    @Test
    public void testGetCustomerByUsername_WhenCustomerExists() {
        String username = "john.doe";

        // Create a sample customer
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");

        // Mock the customer service to return the sample customer
        when(customerService.findByUsername(username)).thenReturn(customer);

        // Call the getCustomerByUsername method
        ResponseEntity<Customer> response = customerController.getCustomerByUsername(username);

        // Verify that the customer service method was called
        verify(customerService, times(1)).findByUsername(username);

        // Verify the response status code and the returned customer
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }
    
//    @Test
//    public void testGetCustomerByUsername_WhenCustomerDoesNotExist() {
//        String username = "jane.smith";
//
//        // Mock the customer service to return null (customer not found)
//        when(customerService.findByUsername(username)).thenReturn(null);
//
//        // Call the getCustomerByUsername method
//        ResponseEntity<Customer> response = customerController.getCustomerByUsername(username);
//
//        // Verify that the customer service method was called
//        verify(customerService, times(1)).findByUsername(username);
//
//        // Verify the response status code
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        
//    }
//    
    @Test
    public void testGetCustomerById_WhenCustomerExists() {
        int customerId = 1;

        // Create a sample customer
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");

        // Mock the customer service to return the sample customer
        when(customerService.findById(customerId)).thenReturn(customer);

        // Call the getCustomerById method
        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        // Verify that the customer service method was called
        verify(customerService, times(1)).findById(customerId);

        // Verify the response status code and the returned customer
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testGetCustomerById_WhenCustomerDoesNotExist() {
        int customerId = 2;

        // Mock the customer service to return null (customer not found)
        when(customerService.findById(customerId)).thenReturn(null);

        // Call the getCustomerById method
        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        // Verify that the customer service method was called
        verify(customerService, times(1)).findById(customerId);

        // Verify the response status code
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals(Optional.empty(),);
    }
    
    @Test
    void testGetAllCustomer_WhenCustomersExist() {
        // Create a list of sample customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "john.doe@example.com"));
        customers.add(new Customer(2, "Jane Smith", "jane.smith@example.com"));

        // Mock the customer service to return the sample customers
        when(customerService.getAllCustomers()).thenReturn(customers);

        // Call the getAllCustomer method
        ResponseEntity<List<Customer>> response = customerController.getAllCustomer();

        // Verify that the customer service method was called
        verify(customerService, times(1)).getAllCustomers();

        // Verify the response status code and the returned customer list
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    public void testGetAllCustomer_WhenNoCustomersExist() {
        // Mock the customer service to return an empty list
        when(customerService.getAllCustomers()).thenReturn(new ArrayList<>());

        // Call the getAllCustomer method
        ResponseEntity<List<Customer>> response = customerController.getAllCustomer();

        // Verify that the customer service method was called
        verify(customerService, times(1)).getAllCustomers();

        // Verify the response status code
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }
    
    @Test
    public void testUpdateProfile_WhenCustomerExists() {
        String username = "john.doe";

        // Create a sample customer
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");

        // Mock the customer service to return the updated customer
        when(customerService.updateProfile(customer, username)).thenReturn(customer);

        // Call the updateProfile method
        ResponseEntity<Customer> response = customerController.updateProfile(username, customer);

        // Verify that the customer service method was called
        verify(customerService, times(1)).updateProfile(customer, username);

        // Verify the response status code and the returned customer
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

//    @Test
//    public void testUpdateProfile_WhenCustomerDoesNotExist() {
//        String username = "jane.smith";
//
//        // Create a sample customer
//        Customer customer = new Customer();
//        customer.setUsername(username);
//        customer.setName("Jane Smith");
//        customer.setEmail("jane.smith@example.com");
//
//        // Mock the customer service to return null (customer not found)
//        when(customerService.updateProfile(customer, username)).thenReturn(null);
//
//        // Call the updateProfile method
//        ResponseEntity<Customer> response = customerController.updateProfile(username, customer);
//
//        // Verify that the customer service method was called
//        verify(customerService, times(1)).updateProfile(customer, username);
//
//        // Verify the response status code
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }
    

    @Test
    public void testGetCustomerByRole_WhenCustomersExist() {
        String role = "admin";

        // Create a list of sample customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "john.doe@example.com", role));
        customers.add(new Customer(2, "Jane Smith", "jane.smith@example.com", role));

        // Mock the customer service to return the sample customers
        when(customerService.findByRole(role)).thenReturn(customers);

        // Call the getCustomerByRole method
        List<Customer> result = customerController.getCustomerByRole(role);

        // Verify that the customer service method was called
        verify(customerService, times(1)).findByRole(role);

        // Verify the returned customer list
        assertEquals(customers, result);
    }

    @Test
    public void testGetCustomerByRole_WhenNoCustomersExist() {
        String role = "customer";

        // Mock the customer service to return an empty list
        when(customerService.findByRole(role)).thenReturn(new ArrayList<>());

        // Call the getCustomerByRole method
        List<Customer> result = customerController.getCustomerByRole(role);

        // Verify that the customer service method was called
        verify(customerService, times(1)).findByRole(role);

        // Verify the returned customer list is empty
        assertEquals(0, result.size());
    }

    @Test
    public void testAddCarDetails_Successful() {
        // Create a sample CarDetails object
        CarDetails carDetails = new CarDetails();
        carDetails.setCarNumber("1");
        carDetails.setCarName("Toyota Camry");
        carDetails.setCarColour("Silver");

        // Call the addCarDetails method
        ResponseEntity<CarDetails> response = customerController.addCarDetails(carDetails);

        // Verify that the customer service method was called
        verify(customerService, times(1)).addCarDetails(carDetails);

        // Verify the response status code and the returned CarDetails object
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carDetails, response.getBody());
    }
//
//    @Test
//    public void testAddCarDetails_Error() {
//        // Create a sample CarDetails object
//        CarDetails carDetails = new CarDetails();
//        carDetails.setCarNumber("1");
//        carDetails.setCarName("Toyota Camry");
//        carDetails.setCarColour("Silver");
//
//        // Mock the customer service to throw an exception
//        doThrow(Exception.class).when(customerService).addCarDetails(carDetails);
//
//        // Call the addCarDetails method
//        ResponseEntity<CarDetails> response = customerController.addCarDetails(carDetails);
//
//        // Verify that the customer service method was called
//        verify(customerService, times(1)).addCarDetails(carDetails);
//
//        // Verify the response status code
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//    }
    
    
}





























//@Test
//public void addCustomer() {
//	Customer customer = new Customer(37,"rajat12", "rajats@gmail.com","ab12","Rajat Singh","pune","9087675430",true,"customer");
//	when(customerService.addCustomer(customer)).thenReturn(customer);
//	assertEquals(customer, customerService.addCustomer(customer));
//}
