package com.bjs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjs.controller.PriceController;
import com.bjs.model.Inventory;
import com.bjs.model.Price;
import com.bjs.repository.InventoryRepository;

@Service
public class InventoryService {

	private static final Logger LOGGER =  LoggerFactory.getLogger(InventoryService.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public Inventory getInventoryDetails(String sku){
		
		LOGGER.info("InventoryMS  InventoryService getInventoryDetails  skuId=" + sku);
		
		Inventory inventory ;
		
		inventory = inventoryRepository.findBySku(sku);
		
		if(inventory == null){
			LOGGER.info("price is null not found in DB");
			inventory = new Inventory();
			inventory.setSku(sku);
			inventory.setInventory(0);
			
		}
		else
			LOGGER.info(inventory.toString());
		
		return inventory;
	}
}
