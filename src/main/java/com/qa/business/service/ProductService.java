package com.qa.business.service;

public interface ProductService {
	
	//C
	String createProduct(String recipe);
	//R
	String getAllProducts();
	String getAProduct(Long id);
	//U
	String updateProduct(String product, Long id);
	//D
	String deleteProduct(Long id);
}
