package com.sccruz.software.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sccruz.software.inventory.model.Item;
import com.sccruz.software.inventory.repository.ItemCustomRepository;
import com.sccruz.software.inventory.repository.ItemRepository;
import com.sccruz.software.inventory.service.ItemService;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpls implements ItemService {

	private ItemRepository itemRepository;
	private ItemCustomRepository itemCustomRepository;
	
	@Autowired
	public ItemServiceImpls(ItemRepository itemRepository, ItemCustomRepository itemCustomRepository) {
		this.itemRepository = itemRepository;
		this.itemCustomRepository = itemCustomRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findAll() {
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public List<Item> findBy(String name, String model, String category, int page, int size) {
		return itemCustomRepository.findBy(name, model, category).stream()
				.skip(page * size)
				.limit(size)
				.collect(Collectors.toList());
	}

}