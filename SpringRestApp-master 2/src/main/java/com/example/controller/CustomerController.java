package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerDetails;
import com.example.domain.Customer;
import com.example.service.CustomerDetailsService;
import com.example.service.CustomerService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/customer")

public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerDetailsService detailsService;
	
	
	 @PostMapping("/add")
	    public String register(@RequestBody Customer customer) {
			return customerService.addCustomer(customer);
	        
	    }
	 @GetMapping(value="/login", produces= "application/json")
	 public String login() {
		 return customerService.login();
	 }
	
	 @GetMapping("/getAllcustomers")
	    public List<Customer> getAllcustomers() {
		 return customerService.getAllCustomers();
		
	    }

	 @GetMapping("/findCustomer/{rest_id}")
	    public Customer findcustomer(@PathVariable  ("rest_id") int rest_id) {
		
		 return customerService.findcustomer(rest_id);
	       
	    }
	 
	 @DeleteMapping("/cancel/{rest_id}")
	    public List<Customer> cancelRegistration(@PathVariable("rest_id") int rest_id) {
	       return customerService.cancelRegistration(rest_id);
	    }
	 @GetMapping("/findcustomerbyname/{username}")
	    public Optional <Customer> findcustomer(@PathVariable  ("username") String username) {
		
	
				 
		return customerService.findCustByUsername(username);
		
	       
	    }
	
	 
	 
}
