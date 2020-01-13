package com.softeam.flight.services;

import java.util.List;
import com.softeam.flight.entities.Transaction;

/**
 * The Interface TransactionService.
 * @author Fatma KERFAHI
 */
public interface TransactionService {
	
	/**
	 * Gets the all transactions.
	 *
	 * @return the all transactions
	 */
	List<Transaction> getAllTransactions();
	
	/**
	 * Save transaction.
	 *
	 * @param transaction the transaction
	 * @return the transaction
	 */
	Transaction saveTransaction(Transaction transaction);
}
