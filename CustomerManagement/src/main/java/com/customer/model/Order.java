package com.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int orderId;
    private String washName;
    private String carName;
    private String carNo;
    private String carModel;
    private double amount;
    private String customerName;
//    private String washerName;
    private Date date;
    private String paymentStatus;
    private String email;

}
