package com.bjs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjs.model.Inventory;
import com.bjs.repository.InventoryRepository;

@Service
public class InventoryService {

	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public Inventory getInventoryDetails(String sku){
		
		return inventoryRepository.findBySku(sku);
	}
}
