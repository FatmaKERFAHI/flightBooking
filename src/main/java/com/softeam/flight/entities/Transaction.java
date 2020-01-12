package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The Class Transaction.
 * @author Fatma KERFAHI
 */
@Entity
public class Transaction implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id transaction. */
	@Id
	private int idTransaction;
	
	/** The type. */
	private	String type;
	
	/** The montant. */
	private double montant;
	
	/** The transaction date. */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date transactionDate;
	
	/** The passenger. */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.ALL }, fetch = FetchType.LAZY)
	private Passenger passenger;
	
	/**
	 * Instantiates a new transaction.
	 */
	public Transaction() {}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return idTransaction;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.idTransaction = id;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the montant.
	 *
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	
	/**
	 * Sets the montant.
	 *
	 * @param montant the new montant
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	/**
	 * Gets the transaction date.
	 *
	 * @return the transaction date
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	/**
	 * Sets the transaction date.
	 *
	 * @param transactionDate the new transaction date
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	/**
	 * Gets the id transaction.
	 *
	 * @return the id transaction
	 */
	public int getIdTransaction() {
		return idTransaction;
	}
	
	/**
	 * Sets the id transaction.
	 *
	 * @param idTransaction the new id transaction
	 */
	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}
	
	/**
	 * Gets the passenger.
	 *
	 * @return the passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}
	
	/**
	 * Sets the passenger.
	 *
	 * @param passenger the new passenger
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	
}
