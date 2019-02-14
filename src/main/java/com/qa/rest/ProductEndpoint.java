package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@Path("/getAProduct/{option}/{contain}")
	@GET
	@Produces({"application/json"})
	public String getAProduct(@PathParam("option") String option, @PathParam("contain") String contains)
	{
		return service.getAProduct(option, contains);
	}
	
	@Path("/createProduct")
	@POST
	@Produces({"application/json"})
	public String createProduct(String recipe)
	{
		return service.createProduct(recipe);
	}
	
	@Path("/deleteProduct/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteProduct(@PathParam("id") Long id)
	{
		return service.deleteProduct(id);
	}
	
	public void setService(ProductService service) {
		this.service = service;
	}
	
}
