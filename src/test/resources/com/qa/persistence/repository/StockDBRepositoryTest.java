package com.qa.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
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

	private static final String MOCK_DATA_ARRAY = "[{\"stockId\":1,\"amount\":0}]";
	private static final String MOCK_OBJECT = "{\"stockId\":1,\"amount\":0}";
	private static final String MOCK_RESPONSE = "Done";


	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		Stock testStock = util.getObjectForJSON(MOCK_OBJECT, Stock.class);
		manager.persist(testStock);
	}

	@Test
	public void testGetAllStocks() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(util.getObjectForJSON(MOCK_OBJECT, Stock.class));
		Mockito.when(query.getResultList()).thenReturn(stocks);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllStock());
	}

	@Test
	public void testCreateStock() {
		String reply = repo.createStock(MOCK_OBJECT);
		Assert.assertEquals(reply, "<div>Message: \"Stock Item has been added\"</div>");
	}

	@Test
	public void testDeleteStock() {
		String reply = repo.deleteStock(1L);
		Assert.assertEquals(reply, "<div>Message: \"Stock Item Successfully Deleted\"</div>");
	}

	@Test
	public void testUpdate() {
		assertEquals("Done",repo.updateStock(MOCK_OBJECT, 1L));		
	}

	@Test
	public void testGetAStock() {
		Mockito.when(manager.find(Stock.class, 1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Stock.class));
		Assert.assertEquals(MOCK_OBJECT, repo.getAStock(1L));
	}
	
	@Test
	public void testDomain()
	{
		Stock fullTest = new Stock(1L, MOCK_RESPONSE, MOCK_RESPONSE, MOCK_RESPONSE, 1);
		Stock domainTest = new Stock();
		domainTest.setLocation(MOCK_RESPONSE);
		domainTest.setAmount(2);
		domainTest.setLastDeliveryDate(MOCK_RESPONSE);
		domainTest.setStockId(1L);
		domainTest.setNextDeliveryDate(MOCK_RESPONSE);
		domainTest.setSupplier(MOCK_RESPONSE);
		domainTest.getLocation();
		domainTest.getAmount();
		domainTest.getLastDeliveryDate();
		domainTest.getStockId();
		domainTest.getNextDeliveryDate();
		domainTest.getSupplier();
		Assert.assertEquals(fullTest,fullTest);
	}

}
