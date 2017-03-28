package com.bjs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjs.model.Price;
import com.bjs.repository.PriceRepository;

@Service
public class PriceService {

	private static final Logger LOGGER =  LoggerFactory.getLogger(PriceService.class);
	
	@Autowired
	private PriceRepository priceRepository;
	
	public Price getPriceDetails(String sku){
		
		LOGGER.info("InventoryMS  PriceService getPriceDetails  skuId=" + sku);
		
		Price price = priceRepository.findBySku(sku);
		
		if(price == null){
			LOGGER.info("price is null not found in DB");
			price = new Price();
			price.setSku(sku);
			price.setPrice(0);
			
		}
		else
			LOGGER.info(price.toString());
		
		return price;
	}
}
