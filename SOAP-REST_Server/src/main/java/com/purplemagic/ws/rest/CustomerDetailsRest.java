package com.purplemagic.ws.rest;

import java.math.BigInteger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.purplemagic.ws.generated.Customer;

@Produces(value = "application/xml")
//@Produces(value = "application/json")
public interface CustomerDetailsRest {

	@GET
	@Path(value = "/customerdetails/{id}")
	Customer getCustomerDetails(@PathParam("id") BigInteger id); 				// get
	
	@POST
	@Path(value = "/customerdetails")
	Customer setCustomerDetails(Customer customer); 							// create/update

}
