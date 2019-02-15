package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ProductRepository;
import com.qa.util.JSONUtil;

public class ProductServiceImpl implements ProductService{
	
	@Inject
	private ProductRepository repo;
	private JSONUtil util;
	
	@Override
	public String createProduct(String product) {
		return repo.createProduct(product);
	}

	@Override
	public String getAllProducts() {
		return repo.getAllProducts();
	}

	@Override
	public String getAProduct(Long id) {
		return repo.getAProduct(id);
	}

	@Override
	public String updateProduct(String product, Long id) {
		return repo.updateProduct(product, id);
	}

	@Override
	public String deleteProduct(Long id) {
		return repo.deleteProduct(id);
	}

	public void setRepo(ProductRepository repo2) {
		this.repo = repo2;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
