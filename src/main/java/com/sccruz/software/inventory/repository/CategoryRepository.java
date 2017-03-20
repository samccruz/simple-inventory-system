package com.sccruz.software.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sccruz.software.inventory.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}