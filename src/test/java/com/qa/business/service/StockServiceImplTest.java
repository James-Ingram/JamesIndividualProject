package com.qa.business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.repository.StockRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@InjectMocks
	StockServiceImpl service;

	@Mock
	StockRepository repo;

	JSONUtil util;
	private static final String MOCK_VALUE = "1";
	private static final String MOCK_OBJECT = "{\"stockId\":1,\"supplier\":\"BigStationaryLtd\",\"warehouse\":\"Salford\",\"location\":\"Manchester\",\"amount\":16,\"lastDeliveryDate\":\"2019-02-04\",\"nextDeliveryDate\":\"2019-02-11\"}";

	@Before
	public void setup() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}

	@Test
	public void testCreate() {
		Mockito.when(repo.createStock(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, service.createStock(MOCK_OBJECT));
		Mockito.verify(repo).createStock(MOCK_OBJECT);
	}

	@Test
	public void testDelete() {
		Mockito.when(repo.deleteStock(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteStock(1L));
		Mockito.verify(repo).deleteStock(1L);
	}

	@Test
	public void testUpdate() {
		Mockito.when(repo.updateStock(MOCK_VALUE, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateStock(MOCK_VALUE, 1L));
		Mockito.verify(repo).updateStock(MOCK_VALUE, 1L);
	}

	@Test
	public void testGetAll() {
		Mockito.when(repo.getAllStock()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllStock());
	}

	@Test
	public void testGetA() {
		Mockito.when(repo.getAStock(1L)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, repo.getAStock(1L));
	}
}
