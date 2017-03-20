package com.sccruz.software.inventory.service;

import java.util.List;

import com.sccruz.software.inventory.model.Category;

public interface CategoryService {

	Category save(Category category);
	
	List<Category> findAll();
}
