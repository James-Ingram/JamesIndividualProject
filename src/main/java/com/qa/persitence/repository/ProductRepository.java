package com.qa.persitence.repository;

public interface ProductRepository {

	//C
	String createProduct(String product);
	//R
	String getAllProducts();
	String getAProduct(Long id);
	//U
	String updateProduct(String product, Long id);
	//D
	String deleteProduct(Long id);
	
}
