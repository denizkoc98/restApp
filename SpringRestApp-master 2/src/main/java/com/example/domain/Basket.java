package com.example.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity

public class Basket {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int orderId;
	// @JsonFormat(pattern = "dd/MM/yyyy")
	 private String orderDate;
	 private int bill;
	 private float totalExpenses;
	 
	 
	 @ManyToMany
	 @JoinTable(name = "hasItem")
	 @JsonIgnoreProperties("belongs")
	 List<BasketItem> hasItem = new ArrayList<> ();
	
	 
	 @OneToOne
	 @JsonBackReference(value="basket-cust") 
	 private Customer customer;
	
	
	
	@OneToMany(mappedBy= "basket")
	@JsonManagedReference(value="discount-basket")
	private List <Discount> discount=new ArrayList<> ();
	
	 
	
	
	
	


	public Basket(int orderId, String orderDate, int bill, float totalExpenses, List<BasketItem> hasItem,
			Customer customer, List<Discount> discount) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.bill = bill;
		this.totalExpenses = totalExpenses;
		this.hasItem = hasItem;
		this.customer = customer;
		this.discount = discount;
	}

	public Basket() {
		
	}

	

	@Transient
	    public Float getTotalOrderPrice() {
	        float sum = 0;
	        List<BasketItem> menuItems = getHasItem();
	        for (BasketItem op : menuItems) {
	            sum += (op.getMenuitem().getPrice())* op.getQuantity();
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




	public float getBill() {
		return bill;
	}




	public void setBill(int bill) {
		this.bill = bill;
	}




	public float getTotalExpenses() {
		return totalExpenses;
	}




	public void setTotalExpenses(float totalExpenses) {
		this.totalExpenses = totalExpenses;
	}




	public List<BasketItem> getHasItem() {
		return hasItem;
	}




	public void setHasItem(List<BasketItem> hasItem) {
		this.hasItem = hasItem;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	public List<Discount> getDiscount() {
		return discount;
	}




	public void setDiscount(List<Discount> discount) {
		this.discount = discount;
	}
	
	
	
	

}
