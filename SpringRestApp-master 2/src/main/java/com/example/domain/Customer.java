package com.example.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity



public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy="customer")
	private List<CreditCard> creditcard = new ArrayList<> ();
	
	@OneToMany(mappedBy="customer")
	private List<Discount> discount = new ArrayList<> ();
	
	
	
	
	public Customer(int id, String firstName, String lastName, String password, String username, String phone,
			String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.phone = phone;
		this.email = email;
		
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
    public List<CreditCard> getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(List<CreditCard> creditcard) {
		this.creditcard = creditcard;
	}
	
	
	
	public Customer () {
    	
    	
    }
}