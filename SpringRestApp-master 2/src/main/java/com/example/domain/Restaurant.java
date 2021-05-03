package com.example.domain;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;


import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import jdk.jfr.DataAmount;

@Entity
public class Restaurant {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rest_id;
	
	private String rest_name;
	private String rest_adress;
	private String rest_phone;
	private String rest_events;
	private String rest_workinghours;
	
	@OneToOne
	@JsonManagedReference
	private Menu rest_menu;
	
	
	public int getRest_id() {
		return rest_id;
	}
	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}
	
	
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getRest_adress() {
		return rest_adress;
	}
	public void setRest_adress(String rest_adress) {
		this.rest_adress = rest_adress;
	}
	public String getRest_phone() {
		return rest_phone;
	}
	public void setRest_phone(String rest_phone) {
		this.rest_phone = rest_phone;
	}
	public String getRest_events() {
		return rest_events;
	}
	public void setRest_events(String rest_events) {
		this.rest_events = rest_events;
	}
	public String getRest_workinghours() {
		return rest_workinghours;
	}
	public void setRest_workinghours(String rest_workinghours) {
		this.rest_workinghours = rest_workinghours;
	}
	
	public Menu getRest_menu() {
		return rest_menu;
	}
	public void setRest_menu(Menu rest_menu) {
		this.rest_menu = rest_menu;
	}
	
	public Restaurant(int rest_id, String rest_name, String rest_adress, String rest_phone, String rest_events,
			String rest_workinghours, Menu rest_menu) {
		super();
		this.rest_id = rest_id;
		this.rest_name = rest_name;
		this.rest_adress = rest_adress;
		this.rest_phone = rest_phone;
		this.rest_events = rest_events;
		this.rest_workinghours = rest_workinghours;
		this.rest_menu =rest_menu;
	}
	public Restaurant() {
	
	}
	
	
	
	
	
}
