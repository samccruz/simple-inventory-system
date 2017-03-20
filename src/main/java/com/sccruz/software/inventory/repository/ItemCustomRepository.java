package com.sccruz.software.inventory.repository;

import java.util.List;

import com.sccruz.software.inventory.model.Item;

public interface ItemCustomRepository {

	List<Item> findBy(String name, String model, String category);
}
