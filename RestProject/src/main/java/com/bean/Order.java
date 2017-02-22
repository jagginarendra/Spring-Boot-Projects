package com.bean;

public class Order {

	private int orderId;

	private int totalPrice;

	private int totalDiscount;

	private int customerId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(int totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String toString() {

		return this.getOrderId() + " " + this.getCustomerId() + " " + this.getTotalPrice();

	}
}
