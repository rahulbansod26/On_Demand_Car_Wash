package com.washer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.washer.model.Order;
import com.washer.model.Washer;
import com.washer.repository.WasherRepository;

@Service
public class WasherServiceImpl implements WasherService{

    @Autowired
    private WasherRepository washerRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    String url1="http://ADMIN/admins";
    //Url to access the methods of Order Service
    String url="http://ORDER/orders";

    @Override
    public Washer addWashers(Washer washer) {

        Washer washers = new Washer();
        washers.setRole("Washer");
        return washerRepository.save(washer);
    }

    @Override
    public Washer findByName(String name) {

        Washer washer = washerRepository.findAll().stream().filter(a->a.getUsername()
                        .equalsIgnoreCase(name)).findAny().orElseThrow(null);
        return washer;
    }

    @Override
    public List<Washer> getAllWashers() {
        return washerRepository.findAll();
    }

    @Override
    public Washer updateWasher(Washer washer) {
        return washerRepository.save(washer);
    }

  //To see the Unassigned orders
    public List<Order> getUnassignedOrders(){
    	Order[] unassignedList = restTemplate.getForObject("http://localhost:9003/order/findUnassigned",Order[].class);
        return Arrays.asList(unassignedList);
    }
    //To update the status of the order by Washer
    public Order updateStatus(Order orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Order> updatedOrder = new HttpEntity<>(orderDetails,headers);
        Order od = restTemplate.exchange(url+"/updateStatus/completed", HttpMethod.PUT,updatedOrder,Order.class).getBody();
        return od;
    }
    //To assign a washer to the order by washer
    public Order assignSelf(Order orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Order> assignedWasher = new HttpEntity<>(orderDetails,headers);
        Order od = restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,Order.class).getBody();
        return od;
    }

}
