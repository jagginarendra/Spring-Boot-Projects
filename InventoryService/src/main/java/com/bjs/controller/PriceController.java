package com.bjs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjs.model.Price;

@RestController
@RequestMapping("/price")
public class PriceController {

	@RequestMapping(value="/sku/{skuId}" , method=RequestMethod.GET)
	public Price getPriceBySku(){
		
		
		return null;
		
	}
	
}
