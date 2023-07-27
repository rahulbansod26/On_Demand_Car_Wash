package com.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.order.controller.OrderController;
import com.order.model.Order;
import com.order.service.OrderServiceImpl;

@SpringBootTest
class OrderDetailsApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	@Mock
	OrderServiceImpl orderService;
	
	@Test
	void contextLoads() {
	}
	
	 @Test
	    public void testPlaceOrder() throws Exception {
	        // Create a sample Order object
	        Order order = new Order();
	        order.setOrderId(1);
	        order.setWashName("Sample Order");

	        // Perform the POST request
	        mockMvc.perform(MockMvcRequestBuilders.post("/place-order")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }

	    @Test
	    public void testGetOrderByName() throws Exception {
	        // Create a sample list of Order objects
	        List<Order> orders = new ArrayList<>();
	        orders.add(new Order(1, "Order 1"));
	        orders.add(new Order(2, "Order 2"));

	        // Mock the service method
	        when(orderService.getOrderListByName("Sample Name")).thenReturn(orders);

	        // Perform the GET request
	        mockMvc.perform(MockMvcRequestBuilders.get("/get-orders/{name}", "Sample Name"))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Order 1"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Order 2"));
	    }

	    @Test
	    public void testGetAllOrders() throws Exception {
	        // Create a sample list of Order objects
	        List<Order> orders = new ArrayList<>();
	        orders.add(new Order(1, "Order 1"));
	        orders.add(new Order(2, "Order 2"));

	        // Mock the service method
	        when(orderService.getAllOrders()).thenReturn(orders);

	        // Perform the GET request
	        mockMvc.perform(MockMvcRequestBuilders.get("/get-all"))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Order 1"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
	                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Order 2"));
	    }
	
	

    @InjectMocks
    private OrderController orderController;

    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void placeOrder_ReturnsOkStatus() throws JsonProcessingException {
        Order order = new Order();
        when(orderService.bookOrder(any(Order.class)));

        ResponseEntity<Order> response = orderController.placeOrder(order);

        verify(orderService, times(1)).bookOrder(any(Order.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void placeOrder_ReturnsNotFoundStatus_WhenExceptionThrown() throws JsonProcessingException {
        Order order = new Order();
        when(orderService.bookOrder(any(Order.class))).thenThrow(Exception.class);

        ResponseEntity<Order> response = orderController.placeOrder(order);

        verify(orderService, times(1)).bookOrder(any(Order.class));
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getOrderByName_ReturnsOrderList() {
        String name = "John";
        List<Order> orderList = new ArrayList<>();
        when(orderService.getOrderListByName(name)).thenReturn(orderList);

        ResponseEntity<List<Order>> response = orderController.getOrderByName(name);

        verify(orderService, times(1)).getOrderListByName(name);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orderList, response.getBody());
    }

    @Test
    void getAllOrders_ReturnsOrderList() {
        List<Order> orderList = new ArrayList<>();
        when(orderService.getAllOrders()).thenReturn(orderList);

        ResponseEntity<List<Order>> response = orderController.getAllOrders();

        verify(orderService, times(1)).getAllOrders();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orderList, response.getBody());
    }


}
