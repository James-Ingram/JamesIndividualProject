package com.qa.business.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.ProductRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl service;
	
	@Mock
	ProductRepository repo;
	
	JSONUtil util;
	private static final String MOCK_VALUE = "1";
	private static final String MOCK_OBJECT = "{\"productId\":1,\"productName\":\"Ring Binder\",\"description\":\"Standard ring binder containing descriptive sleeve\",\"productLine\":\"Back-To-School\",\"price\":3.0,\"mSRP\":2.8}";
	
	@Before
	public void setup() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	
	@Test
	public void testCreate() {
	Mockito.when(repo.createProduct(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
	assertEquals(MOCK_OBJECT,service.createProduct(MOCK_OBJECT));
	Mockito.verify(repo).createProduct(MOCK_OBJECT);
	}
	
	@Test
	public void testDelete() {
		Mockito.when(repo.deleteProduct(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteProduct(1L));
		Mockito.verify(repo).deleteProduct(1L);
	}
	@Test
	public void testUpdate() {
		Mockito.when(repo.updateProduct(MOCK_VALUE, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateProduct(MOCK_VALUE, 1L));
		Mockito.verify(repo).updateProduct(MOCK_VALUE, 1L);
	}
	
	@Test
	public void testGetAll() {
		Mockito.when(repo.getAllProducts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllProducts());
	}
	@Test
	public void testGetA()	{
		Mockito.when(repo.getAProduct(1L)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, repo.getAProduct(1L));
	}
}
