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
	
	@Path("/getAllStock")
	@GET
	@Produces({ "application/json" })
	public String getAllStock()
	{
		return service.getAllStock();
	}
	
	@Path("/getAStock/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAStock(@PathParam("stockId") Long stockId) {
		return service.getAStock(stockId);
	}

	@Path("/createStock")
	@POST
	@Produces({ "application/json" })
	public String addStock(String stock) {
		return service.createStock(stock);
	}

	@Path("/deleteOwner/{owner_id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteStock(@PathParam("stockId") Long stockId) {
		return service.deleteStock(stockId);
	}

	public void setService(StockService service) {
		this.service = service;
	}

}
