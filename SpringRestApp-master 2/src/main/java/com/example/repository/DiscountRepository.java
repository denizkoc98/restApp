package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.domain.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{

	public Discount findByRestaurantId(int restaurantId);

}
