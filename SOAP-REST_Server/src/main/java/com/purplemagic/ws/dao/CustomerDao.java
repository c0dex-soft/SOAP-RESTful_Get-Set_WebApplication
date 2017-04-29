package com.purplemagic.ws.dao;

import java.io.Serializable;
import java.math.BigInteger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.purplemagic.ws.generated.Customer;

@Transactional
@Component(value = "customerDao")
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public boolean customerExists(BigInteger customerId) {
		System.out.println("<Ulazak u Hibernate CUSTOMER-EXISTS metod>");
		Criteria criteria = session().createCriteria(Customer.class);
		criteria.add(Restrictions.idEq(customerId));
		Customer returnedCustomer = (Customer) criteria.uniqueResult();
		System.out.println("ReturnedCustomer: " + returnedCustomer);
		if (returnedCustomer != null) {
			return false;
		} else {
			return false;
		}

	}

	public Customer getCustomer(BigInteger customerId) {
		System.out.println("<Ulazak u Hibernate GET-CUSTOMER metod>");
		Criteria criteria = session().createCriteria(Customer.class);
		criteria.add(Restrictions.idEq(customerId));
		Customer returnedCustomer = (Customer) criteria.uniqueResult();
		System.out.println("ReturnedCustomer: " + returnedCustomer);
		return returnedCustomer;

	}

	public Serializable createCustomer(Customer customer) {
		System.out.println("<Ulazak u Hibernate CREATE-CUSTOMER metod>");
		Serializable identificator = session().save(customer);
		System.out.println("IDENTIFIKATOR: " + identificator.toString());
		return identificator;
	}

	public Customer updateCustomer(Customer customer) {
		System.out.println("<Ulazak u Hibernate UPDATE-CUSTOMER metod>");
		session().update(customer);		
		return customer;
	}
}
