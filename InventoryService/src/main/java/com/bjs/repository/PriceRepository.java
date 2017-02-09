package com.bjs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bjs.model.Price;

public interface PriceRepository extends MongoRepository<Price, String> {

	public Price findBySku(String sku);
}
