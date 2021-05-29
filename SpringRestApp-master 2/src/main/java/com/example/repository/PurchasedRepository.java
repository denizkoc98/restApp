package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Basket;
import com.example.domain.Purchased;

public interface PurchasedRepository extends JpaRepository<Purchased, Integer> {

	
	
	Purchased findById(int id); 

}
