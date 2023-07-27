package com.order.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.order.exception.API_requestException;
import com.order.model.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
	private RestTemplate restTemplate;
    
    @PostMapping("/place-order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws JsonProcessingException {

        try {
            orderService.bookOrder(order);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get-orders/{name}")
    public ResponseEntity<List<Order>> getOrderByName(@PathVariable("name") String name){
        return new ResponseEntity<>(orderService.getOrderListByName(name), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Order>> getAllOrders(){
        try {
            List<Order> list = orderService.getAllOrders();
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @GetMapping("/cancel-order/{id}")
//    public Order cancelOrder(@PathVariable("id") int id) {
//
//    }

    /** Getting consumed by the Washer and Admin model */
	// To filter orders using user emailId
	@GetMapping("/findMyOrders/{useremailid}")
	public List<Order> getMyOrders(@PathVariable String useremailid) {
		return orderRepository.findAll().stream().filter(x -> x.getEmail().contains(useremailid)).collect(Collectors.toList());
	}

	// To find all the completed orders
	@GetMapping("/findCompleted")
	public List<Order> getCompletedOrders() {
		return orderRepository.findAll().stream().filter(x -> x.getStatus().contains("Completed")).collect(Collectors.toList());
	}

	// To find all the pending orders
	@GetMapping("/findPending")
	public List<Order> getPendingOrders() {
		return orderRepository.findAll().stream().filter(x -> x.getStatus().contains("Assign")).collect(Collectors.toList());
	}

	// To find all the cancelled orders
	@GetMapping("/findCancelled")
	public List<Order> getCancelledOrders() {
		return orderRepository.findAll().stream().filter(x -> x.getStatus().contains("Cancelled")).collect(Collectors.toList());
	}

	// To find all the unassigned orders
	@GetMapping("/findUnassigned")
	public List<Order> getUnassignedOrders() {
		//return orderRepository.findAll().stream().filter(x -> (x.getWasherName().contains("NA")&&x.getStatus().contains("Pending"))).collect(Collectors.toList());

		return orderRepository.findAll().stream().filter(x -> x.getStatus().contains("Pending")).collect(Collectors.toList());

	}

	// To fin all the orders by a specific washer
	@GetMapping("/washerSpecificOrder/{washername}")
	public List<Order> getWasherSpecificOrders(@PathVariable String washername) {
		return orderRepository.findAll().stream().filter(x -> x.getCustomerName().contains(washername)).collect(Collectors.toList());
	}
	@GetMapping("/findOneOrder/{username}")
	public List<Order> getOneOrder(@PathVariable String username) {

		return orderRepository.findAll().stream().filter(x -> x.getCustomerName().contains(username)).collect(Collectors.toList());
	}

	 //To cancel the order
//	@PutMapping("/cancelOrder")
//	public String cancelOrder(@RequestBody Order orderDetails) {
//		Order od = orderRepository.findById(orderDetails.getOrderId()).get();
//		od.getStatus("Cancelled");
//		orderRepository.save(od);
//		return "The order with ID -> " + orderDetails.getOrderId() + " is cancelled successfully";
//	}
//	@CrossOrigin("http://localhost:4200")
//	@PutMapping("/cancelOrder/{orderId}")
//	public ResponseEntity<Order> CancelOrder(@PathVariable String orderId ) {
//		Order existingOrder = orderRepository.findById(orderId).orElseThrow(
//				() -> new API_requestException("Order with ID -> " + orderId + " not found, status update failed"));
//		existingOrder.getPaymentStatus("Cancelled");
//		Order order = orderRepository.save(existingOrder);
//		return ResponseEntity.ok(order);
//	}

	/**
	 * Methods that are consumed exclusively by rest templates below this comment
	 */
	// This is called by Admin to update the status of the order(For Completed
	// Order)

	@PutMapping("/updateStatus/completed/{orderId}")
	public ResponseEntity<Order> updateStatus(@PathVariable String orderId ) {
		int number = Integer.parseInt(orderId);
		Order existingOrder = orderRepository.findById(number).orElseThrow(
				() -> new API_requestException("Order with ID -> " + orderId + " not found, status update failed"));
		existingOrder.setStatus("Completed");
		Order order = orderRepository.save(existingOrder);
		return ResponseEntity.ok(order);
	}

	
	@PutMapping("/assignWasher/{orderId}")
	public ResponseEntity<Order> assignWasher(@RequestBody Order od,@PathVariable String orderId ) {
		int number = Integer.parseInt(orderId);
		Order existingOrder = orderRepository.findById(number).orElseThrow(
				() -> new API_requestException("Order with ID -> " + orderId + " not found, status update failed"));
		existingOrder.setWasherName(od.getWasherName());
		existingOrder.setStatus("Assign");
		Order order = orderRepository.save(existingOrder);
		return ResponseEntity.ok(order);
	}
//	@PutMapping("/assignWasher/{orderId}")
//	public Order assignWasher(@RequestBody Order od, @PathVariable String orderId) {
//		boolean doesOrderExists = orderRepository.existsById(od.getOrderId());
//		Order existingOrder = orderRepository.findById(od.getOrderId()).orElse(null);
////		if (doesOrderExists && existingOrder.getWasherName().contains("NA")) {
////			existingOrder.setWasherName(od.getWasherName());
//			if (doesOrderExists && existingOrder.getWasherName().contains("NA")) {
//				existingOrder.setStatus("Assign");
//			return orderRepository.save(existingOrder);
//		} else {
//			throw new API_requestException("Order not found in database, washer not assigned");
//		}
//	}
}
