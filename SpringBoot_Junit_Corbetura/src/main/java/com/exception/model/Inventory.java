package com.exception.model;

public class Inventory {

	private String sku;

	private String inventory;

	public Inventory() {

	}

	public Inventory(String sku, String inventory) {

		this.sku = sku;
		this.inventory = inventory;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

}
