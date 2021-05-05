package com.example.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private float price;
	private String description;
	
	@ManyToOne
	@JsonBackReference
	private Menu menu;
	
	@ManyToMany(mappedBy="hasItem")
	@JsonBackReference
    Set<Basket> belongs;

	public MenuItem(int itemId, String itemName, float price, String description, Menu menu) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.menu = menu;
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
