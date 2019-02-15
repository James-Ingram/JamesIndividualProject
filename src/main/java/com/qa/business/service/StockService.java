package com.qa.business.service;

public interface StockService {

	String createStock(String stock);
	
	String getAllStock();
	
	String updateStock(String stock,Long stockId);
	
	String getAStock(String option, String contains);
	
	String deleteStock(Long stockId);
	
}
