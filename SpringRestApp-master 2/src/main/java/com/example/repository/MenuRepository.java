package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {

}
