package com.softeam.flight.services;

import java.util.List;
import java.util.Optional;

import com.softeam.flight.entities.Transaction;

public interface TransactionService {
	List<Transaction> getAllTransactions();
	Transaction saveTransaction(Transaction transaction);
	Optional<Transaction> findById(int idTransaction);
}
