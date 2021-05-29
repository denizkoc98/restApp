package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Basket;
import com.example.domain.BasketItem;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Integer>{
	Basket findById(int id);
	Basket deleteById(int id);
	

}
