package com.purplemagic.ws.client.controller;

import java.math.BigInteger;

import javax.persistence.NonUniqueResultException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.purplemagic.ws.generated.Customer;

@Controller
@RequestMapping(value = "/rest")
public class RestFulController {

	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/soap-rest-server/services/restCustomerDetails";

	@RequestMapping(value = "/getcustomer", method = RequestMethod.POST)
	public String getCustomerDetails(Model model, @RequestParam("customerId") BigInteger id) {
		System.out.println("Ulazak u REST getUserDetails metod - customerID=" + id);

		// Slucaj kada CustomerID nije prosledjen
		if (id == null) {
			throw new IllegalArgumentException("Customer ID is a mandatory field.");
		}

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/customerdetails").path("/{id}")
				.resolveTemplate("id", id);
		Customer customer = target.request().get(Customer.class);
		if (customer == null) {
			throw new NonUniqueResultException();
		}

		model.addAttribute("title", "RESTful - Detalji o traženom korisniku");
		model.addAttribute("customer", customer);
		return "customerdetails";
	}

	@RequestMapping(value = "/setcustomer", method = RequestMethod.POST)
	public String setCustomerDetails(Model model, Customer customer) {
		System.out.println("Ulazak u REST setCustomerDetails metod - " + customer);

		// Slucaj kada Customer FirstName nije prosledjen
		if (customer.getFirstName() == null || customer.getFirstName().equals("")) {
			throw new IllegalArgumentException("Customer's first name is a mandatory field.");
		}
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/customerdetails");
		Customer returnedCustomer = target.request().post(Entity.entity(customer, MediaType.APPLICATION_XML), Customer.class);
		
		model.addAttribute("title", "RESTful - Detalji o kreiranom/izmenjenom korisniku");
		model.addAttribute("customer", returnedCustomer);
		return "customerdetails";
	}

}
