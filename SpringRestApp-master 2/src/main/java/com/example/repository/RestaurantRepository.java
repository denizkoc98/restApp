package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Restaurant;


@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
	Optional<Restaurant> findById(int id);

	
}
