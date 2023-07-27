package com.carwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
    private String address;
	private boolean enabled=true;
	private String profile;
	private String role;

	public Customer(int i, String string, String string2, String string3, String string4, String string5,
			String string6, boolean b, String string7, String string8) {
		// TODO Auto-generated constructor stub
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Customer(int i, String string, String string2, String role2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
