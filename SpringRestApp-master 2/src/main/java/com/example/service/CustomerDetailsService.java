package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.CustomerDetails;
import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.sun.security.auth.UserPrincipal;

@Service
public class CustomerDetailsService implements UserDetailsService{

	@Autowired
	CustomerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Customer> customer =repository.findByUsername(username);
		/*if (customer==null)
		{
			throw new UsernameNotFoundException("User not found!");
		}

		return new CustomerDetails(customer);*/
		return customer.map(CustomerDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " Not Found"));
		
	}

}
