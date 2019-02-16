package com.qa.integration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.ProductService;
import com.qa.rest.ProductEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class ProductEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ProductEndpoint endpoint;

	@Mock
	private ProductService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	
	public void testGetAllProducts() {
		Mockito.when(service.getAllProducts()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllProducts());
	}

	@Test
	
	public void testCreateProduct() {
		Mockito.when(service.createProduct(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createProduct(MOCK_VALUE2));
		Mockito.verify(service).createProduct(MOCK_VALUE2);
	}

	@Test
	
	public void testDeleteProduct() {
		Mockito.when(service.deleteProduct(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteProduct(1L));
		Mockito.verify(service).deleteProduct(1L);
	}
	
	@Test
	public void testGetAProduct() {
		Mockito.when(service.getAProduct(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE,service.getAProduct(1L));
		Mockito.verify(service).getAProduct(1L);
	}

}
