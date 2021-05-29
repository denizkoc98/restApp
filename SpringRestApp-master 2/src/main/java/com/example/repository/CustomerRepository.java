package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Customer;
import com.example.domain.Restaurant;
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select c from Customer c where c.username = ?1")
	public Optional <Customer> findByUsername(String username);
	

	Customer findById(int id);

}
