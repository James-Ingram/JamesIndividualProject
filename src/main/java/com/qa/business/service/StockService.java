package com.qa.business.service;

public interface StockService {

	String createStock(String owner);
	
	String getAllStock();
	String getAStock(Long owner_id);
	
	String updateStock(String owner,Long owner_id);
	
	String deleteStock(Long owner_id);
	
}
