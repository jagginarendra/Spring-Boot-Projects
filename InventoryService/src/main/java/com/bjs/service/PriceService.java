package com.bjs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjs.model.Price;
import com.bjs.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	public Price getPriceDetails(String sku){
		
		return priceRepository.findBySku(sku);
	}
}
