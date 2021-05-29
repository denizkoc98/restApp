package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.domain.Basket;
import com.example.domain.BasketItem;
import com.example.domain.Customer;
import com.example.domain.Discount;
import com.example.domain.Menu;
import com.example.domain.MenuItem;
import com.example.domain.PurchaseDetails;
import com.example.domain.Purchased;
import com.example.domain.Restaurant;

import com.example.repository.BasketItemRepository;
import com.example.repository.BasketRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.DiscountRepository;
import com.example.repository.MenuItemRepository;
import com.example.repository.MenuRepository;
import com.example.repository.PurchaseDetailsRepository;
import com.example.repository.PurchasedRepository;
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
	@Autowired
	public PurchasedRepository pRepository;
	@Autowired
	public PurchaseDetailsRepository pdRepository;
	@Autowired
	public BasketItemRepository biRepository;

	
	
	
   public Discount findDiscountInList(List <Discount> discounts, int restaurantId){
	   
	   for (Discount discount : discounts) {
           if (discount.getRestaurantId()== restaurantId) {
              
              return discount;
              //bu ratei uyguliycaz
           }
           
           
           	
       }
	return null;
       
   }
   
   public BasketItem findInList2(List <BasketItem> basketitems, int mId){
	   
	   for (BasketItem basketitem : basketitems) {
           if (basketitem.getMenuitem().getItemId()== mId) {
              
              return basketitem;
              
           }
           
           
           	
       }
	return null;
       
   }
   
  public List<BasketItem> newList(List <BasketItem> basketitems, int deletedId){
	   
	  List<BasketItem> newbasketItems = new ArrayList<>();
	   for (BasketItem basketitem : basketitems) {
           if (basketitem.getSalesItemId() != deletedId) {
        	   newbasketItems.add(basketitem);

              
           }

           	
       }
	   return newbasketItems;

       
   }
 public Basket add2(int menuItemId, int customerID) {
	 addToCart( menuItemId,  customerID);
	 Customer customer = customerRepository.findById(customerID);//find the customer
 	Basket basket = customer.getBasket();
 	return basket;
	 
	 
 } 
 public void addToCart(int menuItemId, int customerID) {
	    
 	//basket = basketRepository.findById(basketId);
 	
 	Customer customer = customerRepository.findById(customerID);//basketine ekliycegimiz custi bul
 	Basket basket = customer.getBasket();//custin basketini al 
 	if (basket==null) {//basketi yoksa yenisini olustur
     	basket = new Basket();
     	basket.setCustomer(customer);
     	}
 	
 	//menuitem ekleme
 	MenuItem menuItem = itemRepository.findById(menuItemId);
 	List<BasketItem> basketItems = new ArrayList<>();
 	basketItems= basket.getHasItem();
 	
 	BasketItem bi= findInList2(basketItems, menuItemId);
	
	
	if(bi==null) {
		BasketItem b= new BasketItem(0,1,menuItem);
		biRepository.save(b);
		basketItems.add(b);
		basket.setHasItem(basketItems);
		
		
		
	}
	else {
		bi.setQuantity(bi.getQuantity()+1);
		
	}
	
 	
 	int restaurantId=menuItem.getMenu().getRestaurant().getRest_id(); //get restId for discount
 	
 	
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
 		basket.setBill(0);

 		
 		
 		
 	}
 	else {
 	
 		
 		float rate = discount.getDiscount_rate();
 		//rate uygula baskettaki pricelara
 		float totalEx= basket.getTotalOrderPrice();//ratesiz hali
 		float discounted = totalEx * (rate/100); //indirim hesapla
 		totalEx= totalEx - discounted;
 		
 		basket.setTotalExpenses(totalEx);
 		basket.setBill(discount.getDiscount_rate());

     	
 		
 	}
 
 	
 	basketRepository.save(basket);
 
 }
 
 
	/*
	 * 
	 * public void addToCart(int menuItemId, int customerID) {
	 * 
	 * Customer customer = customerRepository.findById(customerID);//find the
	 * customer Basket basket = customer.getBasket(); if (basket==null) {//if no
	 * basket before create new one basket = new Basket();
	 * basket.setCustomer(customer); }
	 * 
	 * 
	 * //menuitem adding MenuItem menuItem = itemRepository.findById(menuItemId);
	 * List<BasketItem> basketItems = new ArrayList<>(); basketItems=
	 * customer.getBasket().getHasItem();
	 * 
	 * BasketItem bi= findInList2(basketItems, menuItemId);
	 * 
	 * 
	 * if(bi==null) { BasketItem b= new BasketItem(0,1,menuItem);
	 * biRepository.save(b); basketItems.add(b);
	 * customer.getBasket().setHasItem(basketItems);
	 * 
	 * 
	 * 
	 * } else { bi.setQuantity(bi.getQuantity()+1);
	 * 
	 * }
	 * 
	 * 
	 * int restaurantId=menuItem.getMenu().getRestaurant().getRest_id(); //get
	 * restId for discount
	 * 
	 * basket.setOrderDate("trial");
	 * 
	 * //getting discounts List<Discount> discounts = new ArrayList<>(); discounts =
	 * basket.getDiscount();
	 * 
	 * 
	 * Discount discount= findDiscountInList(discounts, restaurantId);
	 * 
	 * if (discount==null) {//if there is no discount before
	 * 
	 * Discount d =new Discount(0,0,0,0, restaurantId); discountRepository.save(d);
	 * d.setBasket(basket);
	 * 
	 * 
	 * discounts.add(d); basket.setDiscount(discounts); float totalEx=
	 * basket.getTotalOrderPrice(); basket.setTotalExpenses(totalEx);
	 * 
	 * } else {
	 * 
	 * 
	 * float rate = discount.getDiscount_rate(); //finding the rate float totalEx=
	 * basket.getTotalOrderPrice();//price without rate float discounted = totalEx *
	 * (rate/100); //price with rate totalEx= totalEx - discounted;
	 * basket.setTotalExpenses(totalEx);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * basket.setBill(discount.getDiscount_rate());
	 * 
	 * basketRepository.save(basket); customerRepository.save(customer);
	 * 
	 * }
	 */
    
    
    public Basket myCart(int custId){
    	
    	Customer customer = customerRepository.findById(custId);
    	Basket basket =customer.getBasket();    	
    
    	
    	return basket;
    	

    }
    
    public void savePurchase(List <BasketItem> basketitems, int cId, float totalprice, String name)
    {
    	List <Purchased> purchased=new ArrayList<>(); 
    	for (BasketItem basketitem: basketitems) { 
  		  MenuItem menuItem = basketitem.getMenuitem();
  		  
  		  int quantity= basketitem.getQuantity();
  		  Purchased object = new Purchased(0,quantity, menuItem);
  		 pRepository.save(object);
  		  purchased.add(object);
  		 
  		  
  	  }
    	PurchaseDetails pDetail = new PurchaseDetails (0,"aa",totalprice,cId,purchased,name);
    	pdRepository.save(pDetail);
    	
    	
    }
	
    public void doPurchase (int customerId) {
    	Customer customer = customerRepository.findById(customerId);
    	Basket basket = customer.getBasket();
    	List<BasketItem> basketitems =basket.getHasItem();
    	float ex= basket.getTotalExpenses();
    	
    
    	
    	//to get the rest_id for discount
    	BasketItem bi=basketitems.get(0);
    	int restId= bi.getMenuitem().getMenu().getRestaurant().getRest_id();
    	String name= bi.getMenuitem().getMenu().getRestaurant().getRest_name();
    	
    	//saving the purchase to OrderDetails
    	savePurchase(basketitems,customerId, ex, name);
    	
    	
    	//find discount for that restaurant
    	List <Discount> discounts = basket.getDiscount();
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
    	if((visitNumber==0)) { 
    		discount.setDiscount_rate(1);
    	}
    	else if((visitNumber==10)) {
    		discount.setDiscount_rate(10);
    		
    	}
    	else if((visitNumber==12)) {
    		discount.setDiscount_rate(12);
    		
    	}
    	else if((total>=1000 & total<=1100)) {
    		discount.setDiscount_rate(10);
    		
    	}
    	else if((visitNumber==1 | (total>250 & total<=350 ))) {
    		discount.setDiscount_rate(5);
    		
    	}
    	else if((visitNumber==1 | (total>100 & total<=250 ))) {
    		discount.setDiscount_rate(3);
    		
    	}
    	
    	
    	else if((visitNumber>=3 & visitNumber<5) & (total>=450)) {
    		discount.setDiscount_rate(7);
    		
    	}
    	else if((visitNumber>=5 & visitNumber<7) & (total>=600)) {
    		discount.setDiscount_rate(8);
    		
    	}
    	else if((visitNumber>=7 & visitNumber<9) & (total>=750)) {
    		discount.setDiscount_rate(9);
    		
    	}
    	else {
    		discount.setDiscount_rate(0);
    	}
    
    	basket.setBill(0);
    	basket.setOrderDate("0");
    	basket.setHasItem(null);
    	basket.setTotalExpenses(0);
    	discountRepository.save(discount);
    	basketRepository.save(basket);
    	
    }
    
    public List<PurchaseDetails> purchasedetails (int custId) {
    	return pdRepository.findByCustomerId(custId);
    	
    	
    }
    
    
    
   public Basket removeItem(int mId, int cId) {
	   Customer customer = customerRepository.findById(cId);
   		Basket basket = customer.getBasket();
   		List<BasketItem> basketItems = new ArrayList<>();
    	basketItems= basket.getHasItem();
    	BasketItem bi= findInList2(basketItems, mId);
    	int q =bi.getQuantity();
    	if (q==1) {
    		//biRepository.deleteById(bi.getSalesItemId());
    		
    		
    		List<BasketItem> basketItems2 = new ArrayList<>();
    		
    		basketItems2 = newList(basketItems,bi.getSalesItemId());
    		
    		basket.setHasItem(basketItems2);
    		int restId= bi.getMenuitem().getMenu().getRestaurant().getRest_id();
    		List<Discount> discounts = new ArrayList<>();
        	discounts = basket.getDiscount();
    		Discount discount= findDiscountInList(discounts, restId);
    		float rate = discount.getDiscount_rate();
    		//finding the rate
    		float totalEx= basket.getTotalOrderPrice();//price without rate
    		float discounted = totalEx * (rate/100); //price with rate
    		totalEx= totalEx - discounted;
    		basket.setTotalExpenses(totalEx);
    		basketRepository.save(basket);
    		return basket;
    		
    	}
    	else {
    		bi.setQuantity((bi.getQuantity())-1);
    		int restId= bi.getMenuitem().getMenu().getRestaurant().getRest_id();
    		List<Discount> discounts = new ArrayList<>();
        	discounts = basket.getDiscount();
    		Discount discount= findDiscountInList(discounts, restId);
    		float rate = discount.getDiscount_rate();
    		//finding the rate
    		float totalEx= basket.getTotalOrderPrice();//price without rate
    		float discounted = totalEx * (rate/100); //price with rate
    		totalEx= totalEx - discounted;
    		basket.setTotalExpenses(totalEx);
    		
    		
        	biRepository.save(bi);
        	basketRepository.save(basket);
        	return basket;
    	}
    	
    
	   
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  
}
