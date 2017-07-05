package com.exception.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.exception.model.Inventory;
import com.exception.service.RogersService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceUnitTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	@InjectMocks
	private RogersService service;

	@Test
	public void testRestController() {

		Inventory inventoryResponse = restTemplate.getForObject("/v1/testexception/1101", Inventory.class);

		//Inventory inventoryResponse = responseEntity.getBody();

		assertEquals("10.0", inventoryResponse.getInventory().toString());
	}

}
