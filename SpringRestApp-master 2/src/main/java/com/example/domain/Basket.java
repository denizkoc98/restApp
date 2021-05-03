package com.example.domain;


import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity

public class Basket {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int orderId;
	 private String orderDate;
	 private int bill;
	 private int totalExpenses;
	 
	 @ManyToMany
	 @JoinTable(
	   name = "hasItem")
	 Set<MenuItem> hasItem;
	 
	
	@OneToOne
	private Discount discount;
	
	public Basket(int orderId, String orderDate, int bill, int totalExpenses, Discount discount) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.bill = bill;
		this.totalExpenses = totalExpenses;
		this.discount = discount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public int getTotalExpenses() {
		return totalExpenses;
	}
	public void setTotalExpenses(int totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Basket() {
		
		
	}
}
