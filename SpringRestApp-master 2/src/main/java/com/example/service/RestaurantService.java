package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.domain.Menu;
import com.example.domain.MenuItem;
import com.example.domain.Restaurant;
import com.example.repository.MenuItemRepository;
import com.example.repository.MenuRepository;
import com.example.repository.RestaurantRepository;

@Service
@CrossOrigin("http://localhost:4200")
public class RestaurantService {
	@Autowired
	public RestaurantRepository restaurantRepository;
	@Autowired
	public MenuRepository menuRepository;
	@Autowired
	public MenuItemRepository itemRepository;
	
	public List<Restaurant> getAllRestaurants(){
	 List<Restaurant> restaurants = new ArrayList<>();
		restaurantRepository.findAll().forEach(restaurants :: add);
		return restaurants;

	}
	
	public String addRestaurant(Restaurant restaurant) {
	restaurantRepository.save(restaurant);
    return "Hi " + restaurant.getRest_name() + " your Registration process successfully completed";
	
	}
	
	public Optional<Restaurant> findRestaurant(int rest_id) {
		
		/*Optional<Restaurant> r = restaurantRepository.findById(rest_id);
		List<MenuItem> ms =r.get().getRest_menu().getMenuitem();
		for (Iterator iterator = ms.iterator(); iterator.hasNext();) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem.getItemName());
		}
		*/
		return restaurantRepository.findById(rest_id);
        
    }
	
	 public List<Restaurant> cancelRegistration(int rest_id) {
	        restaurantRepository.deleteById(rest_id);
	        List<Restaurant> restaurants = new ArrayList<>();
			restaurantRepository.findAll().forEach(restaurants :: add);
			return restaurants;
	    }

	public List<Restaurant> populatedata() {

	
		
		
		
		
	
		Menu m =new Menu(0, "Menu1"+"Menu1");
		//MenuItem mit= new MenuItem(0, "name"+i, 100, "descp"+i,m);
		
	
		Restaurant	r= new Restaurant(0, "Eylul Cafe", "Atasehir Sokak:17 No:3", "2167771818", "Happy Hour at 19.00", "9.00-21.00", m);
		menuRepository.save(m);
		//itemRepository.save(mit);
		restaurantRepository.save(r);
			
			
			MenuItem mit= new MenuItem(0, "Pasta", 30, "Delicious pasta with bolognese sauce",
					"./../../../assets/pasta.png" ,m);
			itemRepository.save(mit);
			
		
		
		
		
		return null;
		
		
		
		
	}
	@CrossOrigin("http://localhost:4200")
	public List<MenuItem> getMenu(int rest_id) {
		Optional<Restaurant> r = restaurantRepository.findById(rest_id);
		List<MenuItem> ms =r.get().getRest_menu().getMenuitem();
		return ms;
		
	}
 
}
