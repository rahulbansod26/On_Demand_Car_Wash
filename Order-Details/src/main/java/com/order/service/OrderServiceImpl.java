package com.order.service;

import com.order.exception.OrdersNotFoundException;
import com.order.model.Order;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order bookOrder(Order order) {

        Random random = new Random();
        order.setOrderId(random.nextInt((9999)));
        order.setPaymentStatus("Pending");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        order.setDate(date);
        
        order.setStatus("Pending");
        order.setWasherName("NA");
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getOrderListByName(String name) {
//        List<Order> orderList = orderRepository.findAll().stream()
//                .filter(a -> a.getCustomerName().equalsIgnoreCase(name)).collect(Collectors.toList());
    	List<Order> orderList=orderRepository.findByCustomerName(name);
        if (orderList == null) {
            throw new OrdersNotFoundException("Sorry, No order found with the provided name");
        }

        return orderList;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

//    @Override
//    public Order cancelOrder(int id) {
//        return orderRepository.deleteById(id);
//    }
}
