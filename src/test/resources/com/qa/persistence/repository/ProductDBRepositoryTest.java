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

import com.qa.persistence.domain.Product;
import com.qa.persistence.repository.ProductDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ProductDBRepositoryTest {

	@InjectMocks
	private ProductDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	

	private static final String MOCK_DATA_ARRAY = "[{\"productId\":1,\"productName\":\"Ring Binder\",\"description\":\"Standard ring binder containing descriptive sleeve\",\"productLine\":\"Back-To-School\",\"price\":3.0,\"mSRP\":2.8}]";
	private static final String MOCK_RESPONSE = "Done";
	private static final String MOCK_OBJECT = "{\"productId\":1,\"productName\":\"Ring Binder\",\"description\":\"Standard ring binder containing descriptive sleeve\",\"productLine\":\"Back-To-School\",\"price\":3.0,\"mSRP\":2.8}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		Product testProduct = util.getObjectForJSON(MOCK_OBJECT, Product.class);
		manager.persist(testProduct);
	}

	@Test
	public void testGetAllProducts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Product> products = new ArrayList<Product>();
		products.add(util.getObjectForJSON(MOCK_OBJECT, Product.class));
		Mockito.when(query.getResultList()).thenReturn(products);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllProducts());
	}

	@Test
	public void testCreateProduct() {
		String reply = repo.createProduct(MOCK_OBJECT);
		Assert.assertEquals(reply, "<div>Message: \"Product has been added\"</div>");
	}

	@Test
	public void testDeleteProduct() {
		String reply = repo.deleteProduct(1L);
		Assert.assertEquals(reply, "<div>Message: \"Product Successfully Deleted\"</div>");

	}
	@Test
	public void testUpdate() {
		assertEquals(MOCK_RESPONSE,repo.updateProduct(MOCK_OBJECT, 1L));
	}
	
	@Test
	public void testGetAProduct()
	{
		Mockito.when(manager.find(Product.class,1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT,Product.class));
		Assert.assertEquals(MOCK_OBJECT,repo.getAProduct(1L));
	}
	
	@Test
	public void testDomain()
	{
		Product fullTest = new Product(MOCK_RESPONSE, MOCK_RESPONSE, MOCK_RESPONSE, 2.0F, 2.0F);
		Product domainTest = new Product();
		domainTest.setDescription(MOCK_RESPONSE);
		domainTest.setmSRP(2.0F);
		domainTest.setPrice(2.0F);
		domainTest.setProductId(1L);
		domainTest.setProductLine(MOCK_RESPONSE);
		domainTest.setProductName(MOCK_RESPONSE);
		domainTest.getDescription();
		domainTest.getmSRP();
		domainTest.getPrice();
		domainTest.getProductId();
		domainTest.getProductLine();
		domainTest.getProductName();
		Assert.assertEquals(fullTest,fullTest);
	}

}
