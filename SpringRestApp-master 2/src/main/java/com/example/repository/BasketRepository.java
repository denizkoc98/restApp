package com.example.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Basket;
import com.example.domain.Customer;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

	
	
	Basket findById(int id);
	
	//@Query("select b from Basket b  join c.addresses a where (a.city = :cityName)")
	//public Basket findByUsername(String username);
}
