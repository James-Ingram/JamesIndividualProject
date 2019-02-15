package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Product;
import com.qa.util.JSONUtil;

public class ProductDBRepository implements ProductRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createProduct(String product) {
		Product aProduct = util.getObjectForJSON(product, Product.class);
		manager.persist(aProduct);
		return "{\"message\": \"Product has been added\"}";
	}

	@Override
	public String getAllProducts() {
		Query query = manager.createQuery("Select a FROM Product a");
		Collection<Product> products = (Collection<Product>) query.getResultList();

		return util.getJSONForObject(products);

	}

	@Override
	public String getAProduct(String option, String contains) {
			Query query = manager.createQuery("Select a FROM Product a where " + option + "="+contains);
			Collection<Product> products = (Collection<Product>) query.getResultList();
			return util.getJSONForObject(products);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteProduct(Long id) {
		// Product productInDB = util.getObjectForJSON(getAProduct(id), Product.class);
		if (manager.contains(manager.find(Product.class, id))) {
			manager.remove(manager.find(Product.class, id));
		}
		return "{\"message\": \"Product sucessfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String updateProduct(String product, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
