package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.domain.Customer;

import com.example.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public String login(){
		return "authenticated successfully" ;
	}
	
	public String addCustomer(@RequestBody Customer customer) {
		String pwd = customer.getPassword(); 
		String encryptPwd = passwordEncoder.encode(pwd);
		customer.setPassword(encryptPwd);
		customerRepository.save(customer);
		return "Hi " + customer.getUsername() + " your Registration process successfully completed";
	}
	
	
	public List<Customer> getAllCustomers(){
	 List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers :: add);
		return customers;

	}
	
	
	
	public Optional<Customer> findcustomer(int rest_id) {
		
		
        return customerRepository.findById(rest_id);
    }
	
	 public List<Customer> cancelRegistration(int rest_id) {
	        customerRepository.deleteById(rest_id);
	        List<Customer> customers = new ArrayList<>();
			customerRepository.findAll().forEach(customers :: add);
			return customers;
	    }

}
