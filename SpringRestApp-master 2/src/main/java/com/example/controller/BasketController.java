package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Basket;
import com.example.service.BasketService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/restaurant")
public class BasketController {

	@Autowired
	BasketService basketService;
	
	@PostMapping("/basket/{menuItemId}/{basketId}/{customerId}")
    public String addToCart(@PathVariable  ("menuItemId") int menuItemId, 
    		@PathVariable  ("basketId") int basketId, 
    		@PathVariable  ("customerId") int customerId ) {
		
         basketService.addToCart(menuItemId, basketId, customerId);
         return "okay";
    }
}
