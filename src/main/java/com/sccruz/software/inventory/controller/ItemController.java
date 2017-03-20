package com.sccruz.software.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sccruz.software.inventory.model.Item;
import com.sccruz.software.inventory.service.ItemService;

@RestController
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired
	public ItemController (ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/items")
	public Object findAll(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "model", required = false) String model,
			@RequestParam(name = "category", required = false) String category,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		return itemService.findBy(name, model, category, page, size);
	}
	
	@PostMapping("/items")
	public Object insert(@RequestBody Item item) {
		return itemService.save(item);
	}
	
	@PutMapping("/items")
	public Object update(@RequestBody Item item) {
		return itemService.save(item);
	}
}
