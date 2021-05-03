package com.example.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity



public class CreditCard {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
	private int cardNumber;
	private String cvv;
	private String cardName;
	private String expireDate;
	
	@ManyToOne
	private Customer customer;

	public CreditCard(int cardId, int cardNumber, String cvv, String cardName, String expireDate, Customer customer) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.cardName = cardName;
		this.expireDate = expireDate;
		this.customer = customer;
	}
	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CreditCard() {
		
		
		
	}
	
}
