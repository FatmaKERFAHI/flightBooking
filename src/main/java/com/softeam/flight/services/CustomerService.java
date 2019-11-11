package com.softeam.flight.services;

import java.util.List;
import java.util.Optional;
import com.softeam.flight.entities.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer saveCustomer(Customer Customer);

	Optional<Customer> findById(int idCustomer);
}
