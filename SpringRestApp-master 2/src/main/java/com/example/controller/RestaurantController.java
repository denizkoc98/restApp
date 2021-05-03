package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.MenuItem;
import com.example.domain.Restaurant;
import com.example.service.RestaurantService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/restaurant")

public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	
	
	 @PostMapping("/register")
	    public String register(@RequestBody Restaurant restaurant) {
			return restaurantService.addRestaurant(restaurant);
	        
	    }
	
	 @GetMapping("/getAllRestaurants")
	    public List<Restaurant> getAllRestaurants() {
		 return restaurantService.getAllRestaurants();
		
	    }
	 
	 @GetMapping("/generatedata")
	    public List<Restaurant> generatedata() {
		 return restaurantService.populatedata();
		
	    }
	 @GetMapping("/getmenu/{rest_id}")
	    public List<MenuItem> getMenuList(@PathVariable  ("rest_id") int rest_id) {
		 return restaurantService.getMenu(rest_id);
		
	    }
	 @GetMapping("/findRestaurant/{rest_id}")
	    public Optional<Restaurant> findRestaurant(@PathVariable  ("rest_id") int rest_id) {
		
		 return restaurantService.findRestaurant(rest_id);
	       
	    }
	 
	 @DeleteMapping("/cancel/{rest_id}")
	    public List<Restaurant> cancelRegistration(@PathVariable("rest_id") int rest_id) {
	       return restaurantService.cancelRegistration(rest_id);
	    }

}
