package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select c from Customer c where c.username = ?1")
	Optional<Customer> findByUsername(String username);

}
