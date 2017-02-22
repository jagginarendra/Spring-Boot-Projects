package com.rest.demo.RestProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bean.Customer;
import com.bean.Order;

public class CustomerOrderDetails {

	private List<Customer> customerList;

	private HashMap<Integer, List<Order>> orderMap;

	public CustomerOrderDetails() {

		Customer customer1 = new Customer();
		customer1.setCustomerId(500);
		customer1.setCustomerName("Narendra");
		customer1.setCity("bangalore");

		Customer customer2 = new Customer();
		customer2.setCustomerId(501);
		customer2.setCustomerName("Akash");
		customer2.setCity("pune");

		Customer customer3 = new Customer();
		customer3.setCustomerId(502);
		customer3.setCustomerName("Ravi");
		customer3.setCity("hyderabad");

		customerList = new ArrayList<Customer>();
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);

		Order order1 = new Order();
		order1.setCustomerId(500);
		order1.setOrderId(100);
		order1.setTotalDiscount(0);
		order1.setTotalPrice(1000);

		Order order2 = new Order();
		order2.setCustomerId(500);
		order2.setOrderId(101);
		order2.setTotalDiscount(0);
		order2.setTotalPrice(1000);

		List<Order> customer1Orders = new ArrayList<Order>();
		customer1Orders.add(order1);
		customer1Orders.add(order2);

		Order order3 = new Order();
		order3.setCustomerId(501);
		order3.setOrderId(102);
		order3.setTotalDiscount(0);
		order3.setTotalPrice(1000);

		List<Order> customer2Orders = new ArrayList<Order>();
		customer2Orders.add(order3);

		orderMap = new HashMap<Integer, List<Order>>();

		orderMap.put(customer1.getCustomerId(), customer1Orders);
		orderMap.put(customer2.getCustomerId(), customer2Orders);

	}
	
	
	public Customer getCustomer(int id){
		
		for(int i = 0 ; i < customerList.size() ; i++)
		{
			if(id == customerList.get(i).getCustomerId()){
				
				
				return customerList.get(i);
			}
			
		}
		
		return null;
	}
	

}
