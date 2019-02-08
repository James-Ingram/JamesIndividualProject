package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long stockId;
	private Long productId;
	private String supplier, warehouse, location;
	private int amount;
	private String lastDeliveryDate, nextDeliveryDate;
	
	public Stock() {
	
	}
	
	public Stock(Long stockId, Long productId, String supplier, String warehouse, String location, int amount) {
		this.stockId = stockId;
		this.productId = productId;
		this.supplier = supplier;
		this.warehouse = warehouse;
		this.location = location;
		this.amount = amount;
	}

	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLastDeliveryDate() {
		return lastDeliveryDate;
	}
	public void setLastDeliveryDate(String lastDeliveryDate) {
		this.lastDeliveryDate = lastDeliveryDate;
	}
	public String getNextDeliveryDate() {
		return nextDeliveryDate;
	}
	public void setNextDeliveryDate(String nextDeliveryDate) {
		this.nextDeliveryDate = nextDeliveryDate;
	}
	
	
	
}
