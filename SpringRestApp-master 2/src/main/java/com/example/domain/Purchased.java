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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Purchased {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchasedId;
	private int quantityOrdered;

	
	@ManyToOne
	@JsonIgnoreProperties("purchaseditem")
	private MenuItem menuitem;
	
	@ManyToMany(mappedBy="purchaseItem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("purchase")
    List<PurchaseDetails> pDetails=  new ArrayList<> ();

	public int getPurchasedId() {
		return purchasedId;
	}

	public void setPurchasedId(int purchasedId) {
		this.purchasedId = purchasedId;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public MenuItem getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(MenuItem menuitem) {
		this.menuitem = menuitem;
	}

	

	public Purchased(int purchasedId, int quantityOrdered, MenuItem menuitem) {
		super();
		this.purchasedId = purchasedId;
		this.quantityOrdered = quantityOrdered;
		this.menuitem = menuitem;
	}
	
	public Purchased() {
		
	}

	


}
