package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.StockRepository;

public class StockServiceImpl implements StockService{

	@Inject
	private StockRepository repo;

	@Override
	public String createStock(String stockId) {
		return repo.createStock(stockId);
	}

	@Override
	public String getAllStock() {
		return repo.getAllStock();
	}

	@Override
	public String getAStock(Long stockId) {
		return repo.getAStock(stockId);
	}

	@Override
	public String updateStock(String stock, Long stockId) {
		return repo.updateStock(stock, stockId);
	}

	@Override
	public String deleteStock(Long stockId) {
		return repo.deleteStock(stockId);
	}
	
	
}
