package com.muneendra.customer.service;

import java.util.List;

import com.muneendra.customer.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();

	public void save(Customer theCustomer);

	public Customer findById(int id);

	public void deleteById(int id);
		
	

}
