package com.sccruz.software.inventory.service;

import java.util.List;

import com.sccruz.software.inventory.model.Item;

public interface ItemService {
	
	Item save(Item item);
	
	List<Item> findAll();
	
	List<Item> findBy(String name, String model, String category, int page, int size);

}
