package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ProductService;

@Path("/product")
public class ProductEndpoint {
	
	@Inject
	private ProductService service;
	
	@Path("/getAllProducts")
	@GET
	@Produces({"application/json"})
	public String getAllProducts() {
		return service.getAllProducts();
	}
	
	@Path("/getAProduct/{id}")
	@GET
	@Produces({"application/json"})
	public String getAProduct(@PathParam("id") Long id)
	{
		return service.getAProduct(id);
	}
	
	@Path("/createProduct")
	@POST
	@Produces({"application/json"})
	public String createProduct(String product)
	{
		return service.createProduct(product);
	}
	
	@Path("/deleteProduct/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteProduct(@PathParam("id") Long id)
	{
		return service.deleteProduct(id);
	}
	
	@Path("/updateProduct/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateProduct(@PathParam("id") Long id, String product )
	{
		return service.updateProduct(product, id);
	}
	
	public void setService(ProductService service) {
		this.service = service;
	}
	
}
