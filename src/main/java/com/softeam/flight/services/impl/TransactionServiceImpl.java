package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Transaction;
import com.softeam.flight.repositories.TransactionRepository;
import com.softeam.flight.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	public List<Transaction> getAllTransactions() {
		return (List<Transaction>) repository.findAll();
	}

	public Transaction saveTransaction(Transaction transaction) {
		repository.save(transaction);
		return transaction;
	}

	public Optional<Transaction> findById(int idTransaction) {
		return repository.findById(String.valueOf(idTransaction));
	}

}
