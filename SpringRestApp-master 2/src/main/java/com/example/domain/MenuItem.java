package com.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private float price;
	private String description;
	
	@ManyToOne
	@JsonBackReference(value="menu-item")
	private Menu menu;
	
	@ManyToMany(mappedBy="hasItem")
	//@JsonBackReference(value="basket-item")
	@JsonIgnoreProperties("hasItem")
    List<Basket> belongs=  new ArrayList<> ();

	public MenuItem(int itemId, String itemName, float price, String description, Menu menu) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.menu = menu;
	}
	
	

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Basket> getBelongs() {
		return belongs;
	}



	public void setBelongs(List<Basket> belongs) {
		this.belongs = belongs;
	}



	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	 public MenuItem () {
		 
	 }
}
