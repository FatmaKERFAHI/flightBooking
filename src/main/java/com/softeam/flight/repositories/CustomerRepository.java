package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.softeam.flight.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	@Query("SELECT c.id FROM Customer c")
	String getIdCustomer();
}
