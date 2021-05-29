package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class BasketItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salesItemId;
	private int quantity;
	

	@ManyToOne
	@JsonIgnoreProperties("menui-basketi")
	private MenuItem menuitem;
	
	@ManyToMany(mappedBy="hasItem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("hasItem")
    List<Basket> belongs=  new ArrayList<> ();
	
	
	public BasketItem() {
		
	}

	

	public int getSalesItemId() {
		return salesItemId;
	}

	public void setSalesItemId(int salesItemId) {
		this.salesItemId = salesItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MenuItem getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(MenuItem menuitem) {
		this.menuitem = menuitem;
	}

	public List<Basket> getBelongs() {
		return belongs;
	}

	public void setBelongs(List<Basket> belongs) {
		this.belongs = belongs;
	}

	public BasketItem(int salesItemId, int quantity, MenuItem menuitem) {
	
		this.salesItemId = salesItemId;
		this.quantity = quantity;
		this.menuitem = menuitem;
	}
	
	

}
