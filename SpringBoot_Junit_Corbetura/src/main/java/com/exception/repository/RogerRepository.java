package com.exception.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exception.model.Inventory;


public interface RogerRepository extends  MongoRepository<Inventory, String> {

	public Inventory findBySku(String sku);
	
	public Inventory save(Inventory inventory);
	
	
}
