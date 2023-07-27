package com.order.service;

import com.order.model.Order;

import java.util.List;

public interface OrderService {

    public Order bookOrder(Order order);

    public List<Order> getOrderListByName(String name);

    public List<Order> getAllOrders();

//    public Order cancelOrder(int id);

}
