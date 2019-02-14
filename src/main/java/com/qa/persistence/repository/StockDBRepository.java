package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Stock;
import com.qa.util.JSONUtil;


public class StockDBRepository implements StockRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createStock(String stock) {
		Stock aStockItem = util.getObjectForJSON(stock, Stock.class);
		manager.persist(aStockItem);
		return "{\"message\": \"Item has been added\"}";
	}

	@Override
	
	public String getAllStock() {
		Query query = manager.createQuery("Select a FROM Stock a");
		Collection<Stock> stockItems = (Collection<Stock>) query.getResultList();
		
		return util.getJSONForObject(stockItems);
	}

	@Override
	public String getAStock(Long stockId) {
		return util.getJSONForObject(manager.find(Stock.class, stockId));
	}

	@Override
	public String updateStock(String stock, Long stock_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteStock(Long stockId) {
		//Stock stockInDB = util.getObjectForJSON(getAStock(stockId), Stock.class);
		if (manager.contains(manager.find(Stock.class, stockId))) {

			manager.remove(manager.find(Stock.class, stockId));
		}
		return "{\"message\": \"Stock Item Sucessfully Deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
