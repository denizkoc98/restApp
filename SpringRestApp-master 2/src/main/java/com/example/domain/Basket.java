package com.example.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity

public class Basket {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int orderId;
	// @JsonFormat(pattern = "dd/MM/yyyy")
	 private String orderDate;
	 private float bill;
	 private int totalExpenses;
	 
	 @ManyToMany
	 @JoinTable(name = "hasItem")
	 @JsonManagedReference
	 List<MenuItem> hasItem = new ArrayList<> ();
	 
	 @ManyToOne
	 @JsonBackReference
	 private Customer customer;
	
	
	@OneToOne
	@JsonManagedReference
	private Discount discount;
	
	
	  public Basket(int orderId, String orderDate, float bill, int totalExpenses, List<MenuItem> hasItem,
			Customer customer, Discount discount) {
		
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.bill = bill;
		this.totalExpenses = totalExpenses;
		this.hasItem = hasItem;
		this.customer = customer;
		this.discount = discount;
	}

	@Transient
	    public Double getTotalOrderPrice() {
	        double sum = 0D;
	        List<MenuItem> menuItems = getHasItem();
	        for (MenuItem op : menuItems) {
	            sum += op.getPrice();
	        }
	        return sum;
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

	public void setBill(float bill) {
		this.bill = bill;
	}

	
	
	public float getBill() {
		return bill;
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

	public List<MenuItem> getHasItem() {
		return hasItem;
	}

	public void setHasItem(List<MenuItem> hasItem) {
		this.hasItem = hasItem;
	}
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Basket() {
		
		
	}
	
	public Basket(int orderID)  {
		this.orderId = orderId;
		
	}
}
