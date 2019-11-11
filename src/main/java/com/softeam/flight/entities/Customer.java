package com.softeam.flight.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "ST_CUSTOMER")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "num_passport")
	private String numPassport;

	public String getNumPassport() {
		return numPassport;
	}

	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}
	
}
