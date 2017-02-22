package com.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private int customerId;

	private String customerName;

	private String city;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {

		return this.getCustomerName() + " " + this.getCustomerId() + " " + this.getCity();

	}

}
