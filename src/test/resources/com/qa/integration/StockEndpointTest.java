package com.qa.integration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.StockService;
import com.qa.rest.StockEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class StockEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private StockEndpoint endpoint;

	@Mock
	private StockService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	
	public void testGetAllStock() {
		Mockito.when(service.getAllStock()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllStock());
	}

	@Test
	
	public void testCreateMovie() {
		Mockito.when(service.createStock(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createStock(MOCK_VALUE2));
		Mockito.verify(service).createStock(MOCK_VALUE2);
	}

	@Test
	
	public void testDeleteMovie() {
		Mockito.when(service.deleteStock(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteStock(1L));
		Mockito.verify(service).deleteStock(1L);
	}

}
