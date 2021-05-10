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
	
	
   public Discount findDiscountInList(List <Discount> discounts, int restaurantId){
	   
	   for (Discount discount : discounts) {
           if (discount.getRestaurantId()== restaurantId) {
              
              return discount;
              //bu ratei uyguliycaz
           }
           
           
           	
       }
	return null;
       
   }
	
	
    public void addToCart(int menuItemId, int customerID) {
    
    	//basket = basketRepository.findById(basketId);
    	
    	Customer customer = customerRepository.findById(customerID);//basketine ekliycegimiz custı bul
    	Basket basket = customer.getBasket();//custin basketini al 
    	if (basket==null) {//basketi yoksa yenisini olustur
        	basket = new Basket();
        	basket.setCustomer(customer);
        	}
    	
    	//menuitem ekleme
    	MenuItem menuItem = itemRepository.findById(menuItemId);
    	List<MenuItem> menuItems = new ArrayList<>();
    	menuItems= basket.getHasItem();
    	menuItems.add(menuItem);
    	
    	int restaurantId=menuItem.getMenu().getRestaurant().getRest_id(); //get restId for discount
    	
    	basket.setBill(menuItem.getPrice());
    	basket.setOrderDate("trial");
    	
    	//getting discounts
    	List<Discount> discounts = new ArrayList<>();
    	discounts = basket.getDiscount();
    	

    	Discount discount= findDiscountInList(discounts, restaurantId);
    	
    	if (discount==null) {//eger daha onceden bir discount yok ise
    		
    		

    		Discount d =new Discount(0,0,0,0, restaurantId);
    		discountRepository.save(d);
    		d.setBasket(basket);
    		
    		discounts.add(d);
    		basket.setDiscount(discounts);
    		float totalEx= basket.getTotalOrderPrice();
    		basket.setTotalExpenses(totalEx);

    		
    		
    		
    	}
    	else {
    	
    		
    		float rate = discount.getDiscount_rate();
    		//rate uygula baskettaki pricelara
    		float totalEx= basket.getTotalOrderPrice();//ratesiz hali
    		float discounted = totalEx * (rate/100); //indirim hesapla
    		totalEx= totalEx - discounted;
    		
    		basket.setTotalExpenses(totalEx);

        	
        	
    		
    	}
    	
    	
        
    	
    	basketRepository.save(basket);
    	
    	
    	
    	
    	
    
    
    }
    
    
    public Basket myCart(int custId){
    	
    	Customer customer = customerRepository.findById(custId);
    	Basket basket =customer.getBasket();    	
    
    	
    	return basket;
    	

    }
    
    public void doPurchase (int customerId) {
    	Customer customer = customerRepository.findById(customerId);
    	Basket basket = customer.getBasket();
    	List <MenuItem> menuItems = basket.getHasItem();
    	List <Discount> discounts = basket.getDiscount();
    	MenuItem menuItem =menuItems.get(0);
    	int restId=menuItem.getMenu().getRestaurant().getRest_id();
    	Discount discount= findDiscountInList(discounts, restId);
    	
    	//get-set visitnumber of discount
    	int visitNumber= (discount.getVisitNumber())+1;
    	discount.setVisitNumber(visitNumber);
    	
    	//get-set totalExpenses of discount
    	float totalEx = basket.getTotalExpenses();
    	float total = totalEx + (discount.getTotalExpenses());
    	discount.setTotalExpenses(total);
    	
    	//get-set rate of discounts
    	int rate = discount.getDiscount_rate();
    	discount.setDiscount_rate(10);
    	
    	customer.getSales();
    	basket.setBill(0);
    	basket.setOrderDate("0");
    	basket.setHasItem(null);
    	basket.setTotalExpenses(0);
    	discountRepository.save(discount);
    	basketRepository.save(basket);
    	
    	
    	
    	
    	
    }
    
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
