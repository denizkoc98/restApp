package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salesId;
	private String orderDate;
	private float bill;
	

	
	@ManyToOne
	@JsonBackReference(value="sales-cust")
	private Customer customer;


	public int getSalesId() {
		return salesId;
	}


	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public float getBill() {
		return bill;
	}


	public void setBill(float bill) {
		this.bill = bill;
	}


	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Sales(int salesId, String orderDate, float bill, Customer customer) {
		super();
		this.salesId = salesId;
		this.orderDate = orderDate;
		this.bill = bill;
		
		this.customer = customer;
	}
	
	public Sales() {
		
	}
}
