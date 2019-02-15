package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Stock;
import com.qa.persistence.repository.StockDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class StockDBRepositoryTest {

	@InjectMocks
	private StockDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	

	private static final String MOCK_DATA_ARRAY = "[{\"stockId\":1,\"stockName\":\"Ring Binder\",\"description\":\"Standard ring binder containing descriptive sleeve\",\"stockLine\":\"Back-To-School\",\"price\":3.0,\"mSRP\":2.8}]";
	private static final String MOCK_SINGLE_ARRAY = "[{\"stockId\":1,\"amount\":0}]";
	private static final String MOCK_OBJECT = "{\"stockId\":1,\"stockName\":\"Ring Binder\",\"description\":\"Standard ring binder containing descriptive sleeve\",\"stockLine\":\"Back-To-School\",\"price\":3.0,\"mSRP\":2.8}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllStocks() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(util.getObjectForJSON(MOCK_OBJECT, Stock.class));
		Mockito.when(query.getResultList()).thenReturn(stocks);
		Assert.assertEquals(MOCK_SINGLE_ARRAY, repo.getAllStock());
	}

	@Test
	public void testCreateStock() {
		String reply = repo.createStock(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Item has been added\"}");
	}

	@Test
	public void testDeleteStock() {
		String reply = repo.deleteStock(1L);
		Assert.assertEquals(reply, "{\"message\": \"Stock Item Sucessfully Deleted\"}");
	}
	
	@Test
	public void testUpdate() {
		
	}
	

}
