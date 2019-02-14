package com.qa.business.service;

public interface ProductService {
	
	//C
	String createProduct(String product);
	//R
	String getAllProducts();
	String getAProduct(String productId, String contains);
	//U
	String updateProduct(String product, Long id);
	//D
	String deleteProduct(Long id);
}
