package com.carwash.model;

public class CarDetails {
	
	private String carName;
	private String carNumber;
	private String carColour;
	
	public CarDetails(String carName, String carNumber, String carColour) {
		super();
		this.carName = carName;
		this.carNumber = carNumber;
		this.carColour = carColour;
	}
	public CarDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarColour() {
		return carColour;
	}
	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	
	
	
	

}
