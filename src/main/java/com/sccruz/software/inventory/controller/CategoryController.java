package com.sccruz.software.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sccruz.software.inventory.model.Category;
import com.sccruz.software.inventory.service.CategoryService;

@RestController
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories")
	public Object finAll() {
		return categoryService.findAll();
	}
	
	@PostMapping("/categories")
	public Object insert(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@PutMapping("/categories")
	public Object update(@RequestBody Category category) {
		return categoryService.save(category);
	}

}
