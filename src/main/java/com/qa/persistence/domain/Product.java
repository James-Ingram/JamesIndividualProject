package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long productId;
	private String productName, description, productLine;
	private float price, mSRP;

	public Product() {

	}

	public Product(Long productId, String productName, String description, String productLine, float price,
			float mSRP) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.productLine = productLine;
		this.price = price;
		this.mSRP = mSRP;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getmSRP() {
		return mSRP;
	}

	public void setmSRP(float mSRP) {
		this.mSRP = mSRP;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
