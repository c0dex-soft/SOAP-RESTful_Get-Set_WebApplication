package com.purplemagic.ws.client.controller;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.purplemagic.ws.generated.Customer;
import com.purplemagic.ws.generated.GetCustomerRequest;
import com.purplemagic.ws.soap.CustomerDetailsPortType;
import com.purplemagic.ws.soap.CustomerDetailsService;

@Controller
@RequestMapping(value = "/soap")
public class SoapController {
	
	private final String WSDL_URL = "http://localhost:8080/soap-rest-server/services/soapCustomerDetails?wsdl";

	@RequestMapping(value = "/getcustomer", method = RequestMethod.POST)
	public String getCustomerDetails(Model model, @RequestParam("customerId") BigInteger id) {
		System.out.println("Ulazak u SOAP getCustomerDetails metod - customerID=" + id);

		// Slucaj kada CustomerID nije prosledjen
		if (id == null) {
			throw new IllegalArgumentException("Customer ID is a mandatory field.");
		}

		try {
			CustomerDetailsService service = new CustomerDetailsService(new URL(WSDL_URL));
			CustomerDetailsPortType port = service.getCustomerDetailsPort();

			GetCustomerRequest request = new GetCustomerRequest();
			request.setCustomerId(id);

			Customer customer = port.getCustomerDetails(request);
			if (customer == null) {
				throw new NonUniqueResultException();
			}

			model.addAttribute("title", "SOAP - Detalji o traženom korisniku");
			model.addAttribute("customer", customer);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "customerdetails";
	}

	@RequestMapping(value = "/setcustomer", method = RequestMethod.POST)
	public String setCustomerDetails(Model model, Customer customer) {
		System.out.println("Ulazak u SOAP setCustomerDetails metod - " + customer);

		// Slucaj kada Customer FirstName nije prosledjen
		if (customer.getFirstName() == null || customer.getFirstName().equals("")) {
			throw new IllegalArgumentException("Customer's first name is a mandatory field.");
		}

		try {
			CustomerDetailsService service = new CustomerDetailsService(new URL(WSDL_URL));
			CustomerDetailsPortType port = service.getCustomerDetailsPort();

			Customer response = null;

			response = port.setCustomerDetails(customer);

			if (response != null) {
				System.out.println("Novi korisnik je uspesno kreiran/izmenjen");
//				GetCustomerRequest request = new GetCustomerRequest();
//				request.setCustomerId(response.getCustomerId());
//
//				Customer returnedCustomer = port.getCustomerDetails(request);
				model.addAttribute("title", "SOAP - Detalji o kreiranom/izmenjenom korisniku");
//				model.addAttribute("customer", returnedCustomer);
				model.addAttribute("customer", response);
				return "customerdetails";
			} else {
				return "notcreated";
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notcreated";
		}

	}
}
