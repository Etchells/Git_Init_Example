package com.glenn.customerdatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glenn.customerdatabase.domain.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
//Create a Repository interface. 
//We have created a repository interface with the name CustomerRepository in the package com.glenn.customerdatabase.repository. 
//It extends the Crud Repository interface.
	
	
	@Query(value = "SELECT * from Customer WHERE firstName = ?1", nativeQuery = true)
	List<Customer> findPersonByNameSQL(String name);
	
	
	
	
}
