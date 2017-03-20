package com.sccruz.software.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sccruz.software.inventory.model.Category;
import com.sccruz.software.inventory.repository.CategoryRepository;
import com.sccruz.software.inventory.service.CategoryService;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

}
