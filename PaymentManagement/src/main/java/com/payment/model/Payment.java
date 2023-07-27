package com.payment.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "payments")
public class Payment {

    @Id
    private ObjectId id;
    private int paymentId;
    private String customerName;
    private String washerName;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
    private LocalDateTime paymentDate;
    private String review;
    private int rating;

    @Override
    public String toString() {
        return "Hey " + customerName + "! \n " +
                " Payment Receipt for your Recent CAR WASH ! " + "\n " +
                " customerName  : " + customerName + " \n " +
                " washerName    : " + washerName + " \n " +
                " orderId       : " + orderId + " \n " +
                " paymentId     : " + paymentId + " \n " +
                " transactionId : " + transactionId + " \n " +
                " paymentStatus : " + paymentStatus + " \n " +
                " amount        : " + amount + " \n " +
                " paymentDate   : " + paymentDate + " \n " +
                " review        : " + review + " \n " +
                " rating        : " + rating + " \n ";
    }

	public String getCustomerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
