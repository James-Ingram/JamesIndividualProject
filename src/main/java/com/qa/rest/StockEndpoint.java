package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.StockService;

@Path("/stock")
public class StockEndpoint {
	
	@Inject
	private StockService service;
	
	@Path("/getAllStocks")
	@GET
	@Produces({"application/json"})
	public String getAllStock() {
		return service.getAllStock();
	}
	
	@Path("/getAStock/{option}/{contain}")
	@GET
	@Produces({"application/json"})
	public String getAStock(@PathParam("option") String option, @PathParam("contain") String contains)
	{
		return service.getAStock(option, contains);
	}
	
	@Path("/createStock")
	@POST
	@Produces({"application/json"})
	public String createStock(String recipe)
	{
		return service.createStock(recipe);
	}
	
	@Path("/deleteStock/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteStock(@PathParam("id") Long id)
	{
		return service.deleteStock(id);
	}
	
	public void setService(StockService service) {
		this.service = service;
	}
	
}
