package com.purplemagic.ws.rest;

import java.io.Serializable;
import java.math.BigInteger;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purplemagic.ws.dao.CustomerDao;
import com.purplemagic.ws.generated.Customer;

@Service(value = "customerDetailsRest")
public class CustomerDetailsRestImpl implements CustomerDetailsRest {

	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer getCustomerDetails(BigInteger id) {
		Customer customer = customerDao.getCustomer(id);
		Customer returnedCustomer = convertNullToJSP(customer);
		return returnedCustomer;
	}

	@Override
	public Customer setCustomerDetails(Customer customer) {
		
		Customer returnedCustomer = null;
		customer = convertEmptyStringToNull(customer);
		
		if (customer.getCustomerId() == null) {
			Serializable id = customerDao.createCustomer(customer);
			BigInteger createdCustomerId = (BigInteger) id;
			returnedCustomer = getCustomerDetails(createdCustomerId);
		} else {
			returnedCustomer = customerDao.updateCustomer(customer);
			returnedCustomer = convertNullToJSP(returnedCustomer);
		}
		return returnedCustomer;
	}

	// Konvertovanje praznih polja forme u NULL vrednosti za upis u bazu podataka
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

	// Konvertovanje NULL vrednosti ucitanih iz baze, da bi ih JSP stranica prikazala kao NULL
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
