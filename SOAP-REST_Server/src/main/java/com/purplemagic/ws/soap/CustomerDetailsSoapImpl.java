package com.purplemagic.ws.soap;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplemagic.ws.dao.CustomerDao;
import com.purplemagic.ws.generated.Customer;
import com.purplemagic.ws.generated.GetCustomerRequest;

@Service
public class CustomerDetailsSoapImpl implements CustomerDetailsPortType {

	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		System.out.println("CustomerDAO: " + customerDao);
	}

	@Override
	public Customer getCustomerDetails(GetCustomerRequest request) {
		BigInteger customerId = request.getCustomerId();
		Customer returnedCustomer = customerDao.getCustomer(customerId);
		returnedCustomer = convertNullToJSP(returnedCustomer);
		return returnedCustomer;
	}

	@Override
	public Customer setCustomerDetails(Customer request) {

		Customer returnedCustomer = null;
		request = convertEmptyStringToNull(request);

		if (request.getCustomerId() == null || request.getCustomerId().equals("")) {
			Serializable identificator = customerDao.createCustomer(request);
			BigInteger createdCustomerId = (BigInteger) identificator;
			GetCustomerRequest gcm = new GetCustomerRequest();
			gcm.setCustomerId(createdCustomerId);
			returnedCustomer = getCustomerDetails(gcm);
		} else {
			returnedCustomer = customerDao.updateCustomer(request);
			returnedCustomer = convertNullToJSP(returnedCustomer);
		}
		return returnedCustomer;
	}

	// Konvertovanje praznih polja forme u NULL vrednosti za upis u bazu
	// podataka
	private Customer convertEmptyStringToNull(Customer customer) {
		if (customer == null) {
			return customer;
		} else {
			if (customer.getFirstName() == null || customer.getFirstName().equals("")) {
				customer.setFirstName(null);
			}
			if (customer.getLastName() == null || customer.getLastName().equals("")) {
				customer.setLastName(null);
			}
			if (customer.getEmail() == null || customer.getEmail().equals("")) {
				customer.setEmail(null);
			}
			if (customer.getPhoneNumber() == null || customer.getPhoneNumber().equals("")) {
				customer.setPhoneNumber(null);
			}
		}
		
		return customer;
	}

	// Konvertovanje NULL vrednosti ucitanih iz baze, da bi ih JSP stranica
	// prikazala kao NULL
	private Customer convertNullToJSP(Customer customer) {
		if (customer == null) {
			return customer;
		} else {
			if (customer.getFirstName() == null || customer.getFirstName().equals("")) {
				customer.setFirstName("NULL");
			}
			if (customer.getLastName() == null || customer.getLastName().equals("")) {
				customer.setLastName("NULL");
			}
			if (customer.getEmail() == null || customer.getEmail().equals("")) {
				customer.setEmail("NULL");
			}
			if (customer.getPhoneNumber() == null || customer.getPhoneNumber().equals("")) {
				customer.setPhoneNumber("NULL");
			}
			return customer;
		}
	}
}
