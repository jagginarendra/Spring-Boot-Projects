package com.eureka.client.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EurekaClientController {

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Autowired private LoadBalancerClient loadBalancerClient;
	 */

	/*
	 * @Autowired private DiscoveryClient discoveryClient;
	 */
	@Value("${price_service_url}")
	private String priceServiceUrl;

	@Value("${inventory_service_url}")
	private String inventoryServiceUrl;

	@RequestMapping("/inventory/sku/{skuId}")
	// @Produces(value=MediaType.APPLICATION_JSON)
	@HystrixCommand(fallbackMethod = "dummy")
	public String getInventoryDetails(@PathVariable String skuId) {

		String inventoryDetails = null;

		inventoryDetails = restTemplate.getForObject(inventoryServiceUrl + skuId, String.class);

		System.out.println(inventoryDetails);

		return inventoryDetails;
	}

	public String inventoryFallback(String skuId) {

		String dummyOutput = "{'sku':" + skuId + "},{'inventory':0}";

		return dummyOutput;
	}

	@RequestMapping("/price/sku/{skuId}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@HystrixCommand(fallbackMethod="priceFallback")
	public String getPriceDetails(@PathVariable String skuId) {

		String priceDetails = null;

		priceDetails = restTemplate.getForObject(priceServiceUrl + skuId, String.class);

		System.out.println(priceDetails);

		return priceDetails;
	}

	public String priceFallback(String skuId) {

		String dummyOutput = "{'sku':" + skuId + "},{'price':0}";

		return dummyOutput;
	}
}
