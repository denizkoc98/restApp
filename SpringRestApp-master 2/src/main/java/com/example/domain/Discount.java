package com.example.domain;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity

public class Discount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int discountId;
private int discount_rate;
private float totalExpenses;
private int visitNumber;
private int restaurantId;

@ManyToOne
@JsonBackReference(value="discount-basket")
private Basket basket;



public Discount(int discountId, int discount_rate, float totalExpenses, int visitNumber, int restaurantId) {
	super();
	this.discountId = discountId;
	this.discount_rate = discount_rate;
	this.totalExpenses = totalExpenses;
	this.visitNumber = visitNumber;
	this.restaurantId = restaurantId;
}


public int getRestaurantId() {
	return restaurantId;
}


public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}


public int getDiscountId() {
	return discountId;
}
public void setDiscountId(int discountId) {
	this.discountId = discountId;
}
public int getDiscount_rate() {
	return discount_rate;
}
public void setDiscount_rate(int discount_rate) {
	this.discount_rate = discount_rate;
}
public float getTotalExpenses() {
	return totalExpenses;
}
public void setTotalExpenses(float totalExpenses) {
	this.totalExpenses = totalExpenses;
}
public int getVisitNumber() {
	return visitNumber;
}
public void setVisitNumber(int visitNumber) {
	this.visitNumber = visitNumber;
}
public Basket getBasket() {
	return basket;
}
public void setBasket(Basket basket) {
	this.basket = basket;
}
 public Discount() {
	 
 }

}


