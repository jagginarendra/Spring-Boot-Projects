package com.exception.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.exception.model.Inventory;
import com.exception.repository.RogerRepository;
import com.exception.service.RogersService;

@RunWith(MockitoJUnitRunner.class)
public class ServiceUnitTest {

	@Mock
	private RogerRepository repository;

	@InjectMocks
	private RogersService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new RogersService();
		repository = Mockito.mock(RogerRepository.class);
	}

	@Test
	public void testCustomerPartyRestController() throws Exception {

		//Mockito.when(service.getMessage("-100")).thenReturn(null);
		Mockito.when(repository.findBySku("100")).thenReturn(new Inventory("100", "100"));
		Mockito.when(service.getMessage("100")).thenReturn(repository.findBySku("100"));
		//Mockito.when(service.getMessage("1001")).thenReturn(new Inventory("1001", "5000"));

		// assertEquals("5000", service.getMessage("1001").getInventory());
		// assertEquals(null, service.getMessage("100"));
		
		
		assertEquals("0", service.getMessage("-100").getInventory());
	}
}
