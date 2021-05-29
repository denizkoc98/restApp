package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Basket;
import com.example.domain.MenuItem;
import com.example.domain.PurchaseDetails;
import com.example.service.BasketService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/restaurant")
public class BasketController {

	@Autowired
	BasketService basketService;
	
	@PostMapping("/basket/addtocart/{menuItemId}/{customerId}")
    public void addToCart(@PathVariable  ("menuItemId") int menuItemId, 
    		
    		@PathVariable  ("customerId") int customerId ) {
		
         basketService.addToCart(menuItemId,  customerId);
        
    }
	
	@GetMapping("/basket/{customerId}")
    public Basket myCartDisplay(@PathVariable  ("customerId") int customerId ) {
		
         return basketService.myCart( customerId);
       
    }
	@GetMapping("/basket/remove/{menuitemId}/{customerId}")
    public Basket remove(@PathVariable  ("menuitemId") int menuitemId ,@PathVariable  ("customerId") int customerId) {
		
         return basketService.removeItem( menuitemId,customerId );
       
    }
	@GetMapping("/basket/add/{menuitemId}/{customerId}")
    public Basket basket(@PathVariable  ("menuitemId") int menuitemId ,@PathVariable  ("customerId") int customerId) {
		
         return basketService.add2( menuitemId,customerId);
       
    }
	
	
	@GetMapping("/purchasedetails/{customerId}")
    public List<PurchaseDetails> purchasedetails(@PathVariable  ("customerId") int customerId ) {
		
         return basketService.purchasedetails( customerId);
       
    }
	
	@PostMapping("/basket/purchase/{customerId}")
    public void purchase(
    		
    		@PathVariable  ("customerId") int customerId ) {
		
         basketService.doPurchase(customerId);
         
    }
	
	
}
