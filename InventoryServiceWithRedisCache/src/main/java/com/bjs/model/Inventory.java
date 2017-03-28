package com.bjs.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "inventory")
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonIgnore
	private String id;

	private String sku;

	private int inventory;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String toString() {

		return "InventoryObj sku=" + this.getSku() + ",price=" + this.getInventory();
	}

}
