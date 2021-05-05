package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.domain.Basket;
import com.example.domain.Customer;
import com.example.domain.Discount;
import com.example.domain.Menu;
import com.example.domain.MenuItem;
import com.example.domain.Restaurant;
import com.example.repository.BasketRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.DiscountRepository;
import com.example.repository.MenuItemRepository;
import com.example.repository.MenuRepository;
import com.example.repository.RestaurantRepository;

@Service
@CrossOrigin("http://localhost:4200")
public class BasketService {
	
	@Autowired
	public RestaurantRepository restaurantRepository;
	@Autowired
	public MenuRepository menuRepository;
	@Autowired
	public MenuItemRepository itemRepository;
	@Autowired
	public BasketRepository basketRepository;
	@Autowired
	public CustomerRepository customerRepository;
	@Autowired
	public DiscountRepository discountRepository;
	
	
   
	
	
    public void addToCart(int menuItemId,int basketId, int customerID) {
    
    	Basket basket = basketRepository.findById(basketId);
    	if (basket==null) {
    	basket = new Basket();
    	}
    	//basket = basketRepository.findById(basketId);
    	
    	Customer customer = customerRepository.findById(customerID);
    	basket.setCustomer(customer);
    	MenuItem menuItem = itemRepository.findById(menuItemId);
    	List<MenuItem> menuItems = new ArrayList<>();
    	menuItems= basket.getHasItem();
    	menuItems.add(menuItem);
    	basket.setBill(menuItem.getPrice());
    	basket.setOrderDate("trial");
    	basket.setTotalExpenses(15);
    	Discount d =new Discount(0,"",0,1);
    	discountRepository.save(d);
    	basket.setDiscount(d);
    	basketRepository.save(basket);
    
    
    }
    
  /*  public List<MenuItem> myCart(String username){
    	
    	List<MenuItem> mi = new ArrayList<>();
    	mi.addAll(basketRepository.findByUsername(username).getHasItem()); 
    	return mi;
    	

    }
    
   
	/*
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
   /* public Iterable<Basket> getAllBaskets() {
        return this.basketRepository.findAll();
    }
	
   
    

 
    public void update(Basket basket) {
        this.basketRepository.save(basket);
    }
	
    public void addtoBasket(MenuItem menuItem) {
    	Discount d= new Discount(0,"",0,0);
    	Basket bsk= new Basket(0, "00/00/00", 0,0,d);
    	List <MenuItem> menuItems = new ArrayList<>();
    	menuItems.add(menuItem);
    	bsk.setHasItem(menuItems);
    	bsk.setBill(menuItem.getPrice());
    	bsk.setTotalExpenses(0);
		
	}
    public List<MenuItem> myCart(int basketid){

        List<MenuItem> cartItems = new ArrayList<>();
        basketRepository.findById(basketid).forEach(cartItems::add);
        return cartItems;
    }*/

}
