package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.PurchaseDetails;
import com.example.domain.Purchased;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer> {

	
	
	PurchaseDetails findById(int id); 
	List<PurchaseDetails> findByCustomerId(int id); 

}
