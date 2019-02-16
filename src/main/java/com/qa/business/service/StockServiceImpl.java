package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.StockRepository;
import com.qa.util.JSONUtil;

public class StockServiceImpl implements StockService{

	@Inject
	private StockRepository repo;

	JSONUtil util;
	@Override
	public String createStock(String stockId) {
		return repo.createStock(stockId);
	}

	@Override
	public String getAllStock() {
		return repo.getAllStock();
	}
	@Override
	public String updateStock(String stock, Long stockId) {
		return repo.updateStock(stock, stockId);
	}

	@Override
	public String deleteStock(Long stockId) {
		return repo.deleteStock(stockId);
	}

	public void setRepo(StockRepository repo2) {
		this.repo = repo2;
	}
	public void setUtil(JSONUtil util)
	{
		this.util = util;
	} 

	@Override
	public String getAStock(Long id) {
		return repo.getAStock(id);
	}
	
	
}
