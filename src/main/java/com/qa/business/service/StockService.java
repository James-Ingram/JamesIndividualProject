package com.qa.business.service;

public interface StockService {

	String createStock(String stock);
	
	String getAllStock();
	String getAStock(Long stockId);
	
	String updateStock(String stock,Long stockId);
	
	String deleteStock(Long stockId);
	
}
