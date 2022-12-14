package com.ajay.customer.service;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajay.customer.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService{

	private Session session;
	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		
		try {
			
			session = sessionFactory.getCurrentSession();
		}
		
		catch(HibernateException e) {
			
			session = sessionFactory.openSession();
			
			
		}
		
	}
	
	@Transactional
	public List<Customer> findAll() {
		
		Transaction tx = session.beginTransaction();
		
		List <Customer> customers = session.createQuery("from Customer").list();
		
		tx.commit();
		
		return customers;
	}

	@Transactional
	public void save(Customer theCustomer) {
		
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(theCustomer);
		
		tx.commit();
		
	}

	@Transactional
	public Customer findById(int id) {
		
		Customer customer = new Customer();
		
		Transaction tx = session.beginTransaction();
		
		customer = session.get(Customer.class, id);
		
		tx.commit();
		
		return customer;
	}

	@Transactional
	public void deleteById(int id) {
		
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);
		
		session.delete(customer);
		
		tx.commit();

		
	}

	@Override
	public void save(com.ajay.customer.service.Customer theCustomer) {
		// TODO Auto-generated method stub
		
	}

}
