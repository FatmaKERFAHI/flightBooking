package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private int idTransaction;
	private	String type;
	private double montant;
	private Date date;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.ALL }, fetch = FetchType.LAZY)
	private Passenger pass;
	public Transaction(int id, String type, double montant, Date date, Passenger pass) {
		super();
		this.idTransaction = id;
		this.type = type;
		this.montant = montant;
		this.date = date;
		this.pass = pass;
	}
	public Transaction() {}
	public int getId() {
		return idTransaction;
	}
	public void setId(int id) {
		this.idTransaction = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + idTransaction + ", type=" + type + ", montant=" + montant + ", date=" + date + ", pass=" + pass
				+ "]";
	}
	/**
	 * @return the use
	 */
	public Passenger getUse() {
		return pass;
	}
	/**
	 * @param use the use to set
	 */
	public void setUse(Passenger pass) {
		this.pass = pass;
	}
	public Map<String, ?> getIdTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
