package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.softeam.flight.entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
	@Query("SELECT t.id FROM Transaction t")
	String getIdTransaction();
}
