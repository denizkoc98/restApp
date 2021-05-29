package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PurchaseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purId;
	private String orderDate;
	private float bill;
	private int customerId;
	private String restname;
	
	 @ManyToMany
	 @JsonIgnoreProperties("purchase")
	 List<Purchased> purchaseItem = new ArrayList<> ();

	public int getPurId() {
		return purId;
	}

	public void setPurId(int purId) {
		this.purId = purId;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<Purchased> getPurchaseItem() {
		return purchaseItem;
	}

	public void setPurchaseItem(List<Purchased> purchaseItem) {
		this.purchaseItem = purchaseItem;
	}

	public PurchaseDetails(int purId, String orderDate, float bill, int customerId, List<Purchased> purchaseItem, String restname) {
		super();
		this.purId = purId;
		this.orderDate = orderDate;
		this.bill = bill;
		this.customerId = customerId;
		this.purchaseItem = purchaseItem;
		this.restname=restname;
	}
	 
	 public String getRestname() {
		return restname;
	}

	public void setRestname(String restname) {
		this.restname = restname;
	}

	public PurchaseDetails(){
		 
	 }
	

}
