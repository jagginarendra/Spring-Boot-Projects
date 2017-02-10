package com.bjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjs.model.Inventory;
import com.bjs.service.InventoryService;

@SuppressWarnings("unused")
@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/inventory/sku/{skuId}")
	public Inventory getInventoryBySku(@PathVariable String skuId) {

		System.out.println("sku=" + skuId);

		return inventoryService.getInventoryDetails(skuId);

	}

}
