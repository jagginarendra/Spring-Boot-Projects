package com.flipkart.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("orders")
public class OrderController {

	public OrderController() {

		System.out.println("OrderController()");
	}

	@GET
	@Path("/{orderId}/{testId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void getCustomerOrderById(@PathParam("customerId") String customerId, @PathParam("orderId") int orderId) {

		System.out.println("orderId=" + orderId);
		System.out.println("customerId=" + customerId);
		
	}
}
