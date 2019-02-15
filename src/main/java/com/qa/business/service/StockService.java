package com.qa.business.service;

public interface StockService {

	String createStock(String stock);
	
	String getAllStock();
	
	String updateStock(String stock,Long stockId);
	
	String getAStock(Long id);
	
	String deleteStock(Long stockId);
	
}
