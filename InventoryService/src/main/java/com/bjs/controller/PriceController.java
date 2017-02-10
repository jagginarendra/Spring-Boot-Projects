package com.bjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjs.model.Price;
import com.bjs.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@RequestMapping(value="/sku/{skuId}" , method=RequestMethod.GET)
	public Price getPriceBySku(@PathVariable String skuId){
		
		
		System.out.println("sku=" + skuId);

		return priceService.getPriceDetails(skuId);
		
	}
	
}
