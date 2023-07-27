package com.washer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private int orderId;
    private String washName;
    private String carName;
    private String carNo;
    private String carModel;
    private double amount;
    private String customerName;
  private String washerName;
    private Date date;
    private String paymentStatus;
    private String email;
    private String status;

    

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Order(int orderId, String washName, String carName, String carNo, String carModel, double amount,
			String customerName, String washerName, Date date, String paymentStatus, String email, String status) {
		super();
		this.orderId = orderId;
		this.washName = washName;
		this.carName = carName;
		this.carNo = carNo;
		this.carModel = carModel;
		this.amount = amount;
		this.customerName = customerName;
		this.washerName = washerName;
		this.date = date;
		this.paymentStatus = paymentStatus;
		this.email = email;
		this.status = status;
	}



	public String getWasherName() {
		return washerName;
	}



	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}



	public Order(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getWashName() {
        return washName;
    }

    public void setWashName(String washName) {
        this.washName = washName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

//    public String getWasherName() {
//        return washerName;
//    }
//
//    public void setWasherName(String washerName) {
//        this.washerName = washerName;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
