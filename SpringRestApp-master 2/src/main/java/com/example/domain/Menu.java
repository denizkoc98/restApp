package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity

public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int menuId;
	private String mealName;
	
	@OneToOne(mappedBy = "rest_menu")
	@JsonBackReference(value="menu-rest")
	 private Restaurant restaurant;
	
	@OneToMany(mappedBy="menu")
	@JsonManagedReference(value="menu-item")
	private List<MenuItem> menuitem = new ArrayList<> ();

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<MenuItem> getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(List<MenuItem> menuitem) {
		this.menuitem = menuitem;
	}

	
	

	

	public Menu(int menuId, String mealName) {
		super();
		this.menuId = menuId;
		this.mealName = mealName;
		//this.menuitem = menuitem;
	}

	public Menu  () {
		
		
	}
	
}
