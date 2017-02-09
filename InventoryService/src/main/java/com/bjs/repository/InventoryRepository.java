package com.bjs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bjs.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

	public Inventory findBySku(String sku);
}
