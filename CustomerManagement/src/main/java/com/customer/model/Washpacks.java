package com.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Washpacks {

    @Id
    private int id;
    private String packName;
    private double amount;
    private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Washpacks(int id, String packName, double amount, String description) {
		super();
		this.id = id;
		this.packName = packName;
		this.amount = amount;
		this.description = description;
	}
	public Washpacks() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
