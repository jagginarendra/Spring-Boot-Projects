package com.flipkart.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bean.Customer;
import com.bean.CustomerFilterBean;
import com.flipkart.exception.DataNotFoundException;
import com.rest.demo.RestProject.CustomerOrderDetails;

@Path("/customer")
public class CustomerController {

	CustomerOrderDetails service = new CustomerOrderDetails();

	@GET()
	@Path("/{customerId}")
	// @Produces(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Customer getCustomer(@BeanParam CustomerFilterBean customerFilterBean) {

		System.out.println("client=" + customerFilterBean.getClient());
		System.out.println("company=" + customerFilterBean.getCompany());
		System.out.println("customerId=" + customerFilterBean.getCustomerId());

		Customer customer = service.getCustomer(customerFilterBean.getCustomerId());

		if(customer == null){
			throw new DataNotFoundException("not customer found with id="+customerFilterBean.getCustomerId());
		}
		
		return customer;
	}

	// putting request to order resource

	@Path("/{customerId}/orders")
	public OrderController getOrderResource() {

		return new OrderController();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addCustomer(Customer customer , @Context UriInfo uriInfo) throws URISyntaxException {

		System.out.println(customer.toString());
		URI uri = uriInfo.getAbsolutePathBuilder().path("5").build();
		customer.setCustomerId(5);
		return Response.created(uri).entity(customer).build();

	}/*
		 * 
		 * @GET() // @Produces(MediaType.APPLICATION_JSON)
		 * 
		 * @Produces(MediaType.APPLICATION_JSON) public Response
		 * testing(@HeaderParam("client") String client, @CookieParam("Cookie")
		 * String cookie) {
		 * 
		 * System.out.println(client); System.out.println(cookie);
		 * 
		 * 
		 * List<Player> namesList = new ArrayList<Player>();
		 * 
		 * namesList.add(new Player("sachin")); namesList.add(new
		 * Player("sourav")); namesList.add(new Player("sehwag"));
		 * namesList.add(new Player("dravid"));
		 * 
		 * return Response.ok().entity(new
		 * GenericEntity<List<Player>>(namesList) {}).cookie(new
		 * NewCookie("name", "Hello Cookie")).build();
		 * 
		 * }
		 * 
		 * 
		 * @GET
		 * 
		 * @Path("/context") public String testContext(@Context UriInfo uriInfo
		 * , @Context HttpHeaders headers){
		 * 
		 * System.out.println( uriInfo.getAbsolutePath());
		 * System.out.println(uriInfo.getQueryParameters()); System.out.println(
		 * headers.getCookies());
		 * 
		 * return "test"; }
		 */

}
