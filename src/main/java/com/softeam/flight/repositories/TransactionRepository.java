package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
	@Query("SELECT t.id FROM Transaction t")
	String getIdTransaction();
}
