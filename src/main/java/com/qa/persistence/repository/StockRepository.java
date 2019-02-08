package com.qa.persistence.repository;

public interface StockRepository {
	//C
String createStock(String stock);
	
	String getAllStock();
	String getAStock(Long stockId);
	
	String updateStock(String stock,Long stockId);
	
	String deleteStock(Long stock);
}
