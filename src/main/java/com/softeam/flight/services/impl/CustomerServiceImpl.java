package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Customer;
import com.softeam.flight.repositories.CustomerRepository;
import com.softeam.flight.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	public List<Customer> getAllCustomers() {
		return (List<Customer>) repository.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		repository.save(customer);
		return customer;
	}

	public Optional<Customer> findById(int idCustomer) {
		return repository.findById(String.valueOf(idCustomer)) ;
	}

}
