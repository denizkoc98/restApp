package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Menu;
import com.example.repository.MenuRepository;


@Service
public class MenuService {

	@Autowired
	public MenuRepository menuRepository;
	
	public List<Menu> getMenu(){
	 List<Menu> menus = new ArrayList<>();
		menuRepository.findAll().forEach(menus :: add);
		return menus;

	}
	
	public String addMenu(Menu menu) {
	menuRepository.save(menu);
    return "Hi " + menu.getMealName() + " restaurant menu is successfully added.";
	
	}
	
}
