package com.bjs.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryControllerTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/inventory/sku/1100");
    }
	
	@Test
	public void inventoryControllerTest() throws Exception {

		// String body = this.restTemplate.getForObject("/inventory/sku/1100",
		// String.class);

		String response = template.getForObject(base.toString(), String.class);
		assertThat(response).isEqualTo("Greetings from Spring Boot!");
	}

	public void priceControllerTest() {

	}
}
