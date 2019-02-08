package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	@Inject
	private ProductRepository repo;
	
	@Override
	public String createProduct(String product) {
		return repo.createProduct(product);
	}

	@Override
	public String getAllProducts() {
		return repo.getAllProducts();
	}

	@Override
	public String getAProduct(Long productId) {
		return repo.getAProduct(productId);
	}

	@Override
	public String updateProduct(String product, Long id) {
		return repo.updateProduct(product, id);
	}

	@Override
	public String deleteProduct(Long id) {
		return repo.deleteProduct(id);
	}

}
