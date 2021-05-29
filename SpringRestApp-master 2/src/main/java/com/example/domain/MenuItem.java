package com.example.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private float price;
	private String description;
	private String image;
	
	@ManyToOne
	@JsonBackReference(value="menu-item")
	private Menu menu;
	
	
	
	@OneToMany(mappedBy="menuitem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("menui-basketi")
	private List<BasketItem> basketItem = new ArrayList<> ();
	
	@OneToMany(mappedBy="menuitem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("purchaseditem")
	private List<Purchased> purchased = new ArrayList<> ();
	
//	@OneToMany(mappedBy="menuitem", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("menui-orderedi")
//	private List<OrderedItem> orderItem = new ArrayList<> ();

	public MenuItem(int itemId, String itemName, float price, String description, String image,Menu menu) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.image=image;
		this.menu = menu;
	}
	
	

	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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
