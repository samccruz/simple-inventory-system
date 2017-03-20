package com.sccruz.software.inventory.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sccruz.software.inventory.model.Item;
import com.sccruz.software.inventory.repository.ItemCustomRepository;

@Repository
public class ItemCustomRepositoryImpl implements ItemCustomRepository {
	
	private HibernateEntityManager hem;
	
	@Autowired
	public ItemCustomRepositoryImpl(EntityManager factory) {
		if (factory.unwrap(HibernateEntityManager.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.hem = factory.unwrap(HibernateEntityManager.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> findBy(String name, String model, String category) {
		Criteria criteria = hem.getSession().createCriteria(Item.class);
		
		if (name != null && !name.isEmpty()) {
			criteria.add(Restrictions.like("name", "%" + name + "%").ignoreCase());
		}
		if (model != null && !model.isEmpty()) {
			criteria.add(Restrictions.like("model", "%" + model + "%").ignoreCase());
		}
		if (category != null && !category.isEmpty()) {
			criteria.add(Restrictions.eq("category.name", category).ignoreCase());
		}
		
		return criteria.list();
	}

}
