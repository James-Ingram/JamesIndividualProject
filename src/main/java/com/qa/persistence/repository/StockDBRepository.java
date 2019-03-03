package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Product;
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
		return "<div>Message: \"Stock Item has been added\"</div>";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAllStock() {
		Query query = manager.createQuery("Select a FROM Stock a");
		Collection<Stock> stockItems = (Collection<Stock>) query.getResultList();
		
		return util.getJSONForObject(stockItems);
	}

	@Override
	public String updateStock(String stock, Long id) {
		Stock temp = new Stock();
		temp = util.getObjectForJSON(stock, Stock.class);
		manager.persist(temp);
		manager.remove(manager.find(Stock.class,id));		
		return "Done";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteStock(Long stockId) {
			manager.remove(manager.find(Stock.class, stockId));
		return "<div>Message: \"Stock Item Successfully Deleted\"</div>";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String getAStock(Long id) {
			return util.getJSONForObject(manager.find(Stock.class, id));
	}
	

}
