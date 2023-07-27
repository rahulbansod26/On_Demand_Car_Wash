package com.gateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FallbackController {

    @GetMapping("/customerServiceFallback")
    public String customerServiceFallback(){
        return "Customer-Service is down at this time !!!!," +
                "Please try again later";
    }

    @GetMapping("/adminServiceFallback")
    public String adminServiceFallback(){
        return "Admin-Service is down at this time !!!!," +
                "Please try again later";
    }


}
