package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Menu;
import com.example.service.MenuService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	
	
	 @PostMapping("/add")
	    public String add(@RequestBody Menu menu) {
			return menuService.addMenu(menu);
	        
	    }
	
	 @GetMapping("/getMenu")
	    public List<Menu> getMenu() {
		 return menuService.getMenu();
		
	    }

	 
	    
	
	
}
