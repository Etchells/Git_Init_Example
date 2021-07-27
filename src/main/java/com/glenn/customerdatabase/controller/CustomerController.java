package com.glenn.customerdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glenn.customerdatabase.domain.Customer;
import com.glenn.customerdatabase.services.CustomerService;


 				//The @SpringBootApplication annotation enables auto-configuration and component scanning. 
				//During the scanning process, the @RestController annotation is looked up and a Spring bean is created 
@RestController	//from the MyController class.
@RequestMapping//("/main_page") // http://localhost:8080/main_page     @RequestMapping:	is a Class level request config
public class CustomerController {

	@Autowired // Enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	CustomerService customerService;
	
	// Creating a get mapping that retrieves all the customers from the database (Fetching data FROM a database)
	@GetMapping(path = "/customer")
	private List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	// Create a get mapping that retrieves the detail of a specific customer (Fetching data FROM a database)
	@GetMapping(path = "/customer/{id}")
	private Customer getCustomer(@PathVariable("id")int id) {	// @PathVariable: Template holder for a value that we get from the USER
		return customerService.getCustomerById(id);
	}
	
	// Creating a delete mapping that deletes a specific customer (Remove data from the database)
	@DeleteMapping(path = "/customer/{id}")
	private String deleteCustomer(@PathVariable("id")int id) {	// @PathVariable: Template holder for a value that we get from the USER
		customerService.delete(id);
		return "Record has been deleted";
	}
	
	// Creating a post mapping that post the customer detail in the database (Send data TO the database)
	@PostMapping(path = "/customer")
	private String saveCustomer(@RequestBody Customer customer) {	// @RequestBody: Get information from the USER
		customerService.saveOrUpdate(customer);
//		return customer.getId();
		return "Details have been added to the databse";
	}
	
	// Create a put mapping that will replace an existing record by id stored in database
	@PutMapping(path = "/customer/{id}")
	public String updateCustomer(@PathVariable("id")int id, @RequestBody Customer customerDetails) { //creating a customerDetails body from Customer class reteiving all the getters and setters
		Customer user =customerService.getCustomerById(id);
		user.setFirstName(customerDetails.getFirstName());
		user.setLastName(customerDetails.getLastName());
		user.setAge(customerDetails.getAge());
		user.setDob(customerDetails.getDob());
		user.setEmail(customerDetails.getEmail());
		customerService.saveOrUpdate(customerDetails);
		return "Record has been updated";		
	}
	//--------------------------------------------------------------------------------------------------------------

	
	//	@PatchMapping:		Partially update a RECORD in a database ******************

	
		
	

}
