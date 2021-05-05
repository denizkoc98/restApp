package com.example.domain;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity

public class Discount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int discountId;
private String discount_rate;
private int totalExpenses;
private int visitNumber;

@OneToOne(mappedBy = "discount")
@JsonBackReference
private Basket basket;



public Discount(int discountId, String discount_rate, int totalExpenses, int visitNumber) {
	super();
	this.discountId = discountId;
	this.discount_rate = discount_rate;
	this.totalExpenses = totalExpenses;
	this.visitNumber = visitNumber;
}
public int getDiscountId() {
	return discountId;
}
public void setDiscountId(int discountId) {
	this.discountId = discountId;
}
public String getDiscount_rate() {
	return discount_rate;
}
public void setDiscount_rate(String discount_rate) {
	this.discount_rate = discount_rate;
}
public int getTotalExpenses() {
	return totalExpenses;
}
public void setTotalExpenses(int totalExpenses) {
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


