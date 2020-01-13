package com.softeam.flight.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softeam.flight.entities.Transaction;
import com.softeam.flight.repositories.TransactionRepository;
import com.softeam.flight.services.TransactionService;

/**
 * The Class TransactionServiceImpl.
 * @author Fatma KERFAHI
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	/** The transaction repository. */
	@Autowired
	private TransactionRepository transactionRepository;

	/**
	 * Gets the all transactions.
	 *
	 * @return the all transactions
	 */
	public List<Transaction> getAllTransactions() {
		return (List<Transaction>) transactionRepository.findAll();
	}

	/**
	 * Save transaction.
	 *
	 * @param transaction the transaction
	 * @return the transaction
	 */
	public Transaction saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		return transaction;
	}

}
