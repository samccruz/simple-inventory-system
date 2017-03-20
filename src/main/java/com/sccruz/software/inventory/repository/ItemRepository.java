package com.sccruz.software.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sccruz.software.inventory.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	@Query("select i from Item i where name like ISNULL(:name,'')+'%' and model like ISNULL(:model,'')+'%' and category like ISNULL(:category,'')+'%'")
	Page<Item> findBy(@Param("name") String name, @Param("model") String model, @Param("category") String category, Pageable pageable);
}
