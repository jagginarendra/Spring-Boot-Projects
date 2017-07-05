package com.exception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.model.Inventory;
import com.exception.repository.RogerRepository;

@Service
public class RogersService {

	@Autowired
	private RogerRepository repository;
	
	public Inventory getMessage(String input) {

		Inventory resultInventory;
		
		int skuID = Integer.parseInt(input);

		if(skuID > 0 && skuID < 50000){
			
			resultInventory = repository.findBySku(input);
			
		}else{
			
			resultInventory = new Inventory(input , "0");
		}
		
		return resultInventory;
	}
}
