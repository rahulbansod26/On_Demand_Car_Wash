package com.washer.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
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


import com.washer.model.Order;
import com.washer.model.WashPacks;
import com.washer.model.Washer;
import com.washer.service.WasherServiceImpl;
import com.washer.utilities.GlobalResources;

@RestController
@RequestMapping("/washer")
@CrossOrigin("*")
public class WasherController {

    @Autowired
    private WasherServiceImpl washerService;
    
    @Autowired
	private RestTemplate restTemplate;

    private Logger logger = GlobalResources.getLogger(WasherController.class);

    @PostMapping("/addWasher")
    public ResponseEntity<Washer> addWashers(@RequestBody Washer washer)
    {
        String methodName = "(addWashers)";
        try
        {
            logger.info(methodName + "Called");
            washerService.addWashers(washer);
            return ResponseEntity.ok(washer);
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @GetMapping("/get-washer/{name}")
    public ResponseEntity<Washer> getWasherById(@PathVariable("name") String name)
    {
        String methodName = "(getWasherById)";
        try
        {
            logger.info(methodName + "Called");
            Washer washer = washerService.findByName(name);
            return new ResponseEntity<Washer>(washer,HttpStatus.OK);
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @GetMapping("/getAllWasher")
    public ResponseEntity<List<Washer>> getAllWashers()
    {
        String methodName = "(getAllWashers)";
        try
        {
            logger.info(methodName + "Called");
            List<Washer> list = washerService.getAllWashers();
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }

    @PutMapping("/updateWasher")
    public ResponseEntity<Washer> updateWasher(@RequestBody Washer washer)
    {
        String methodName = "(updateWasher)";
        try
        {
            logger.info(methodName + "Called");
            return ResponseEntity.ok(this.washerService.updateWasher(washer));
        }
        catch (Exception e)
        {
            logger.error(methodName,"Something went wrong!!!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }
    }
    
    @GetMapping("/allpacks")
	public List<WashPacks> getWashpacks()
	{
		String baseurl = "http://localhost:9001/admin/get-all";
		WashPacks[] washpacks = restTemplate.getForObject(baseurl,WashPacks[].class);
		return Arrays.asList(washpacks);
	}
    
    @GetMapping("/findUnassigned")
    public List<Order> getUnassignedOrders(){
        return washerService.getUnassignedOrders();
    }
    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus/completed")
    public Order updateStatusoftheOrder(@RequestBody Order orderDetails){
        return washerService.updateStatus(orderDetails);
    }
    //To assign a washer to the order by washer
    @PutMapping("/assign")
    public Order assignSelf(@RequestBody Order orderDetails){
        return washerService.assignSelf(orderDetails);
    }

}
