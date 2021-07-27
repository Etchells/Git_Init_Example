package com.glenn.customerdatabase.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glenn.customerdatabase.domain.Customer;
import com.glenn.customerdatabase.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired // Enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	CustomerRepository customerRepository;
	// constructor
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	// Getting all Customer RECORDS
	public List<Customer>getAllCustomer(){
		List<Customer>customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}

	// Getting a specific RECORD
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElseThrow(); //.get or .orElseThrow  or make method optional
	}
	
	// Updating a RECORD
	public void saveOrUpdate(Customer customer){
		customerRepository.save(customer);
	}
	
	// Deleting a specific RECORD
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
	
}
