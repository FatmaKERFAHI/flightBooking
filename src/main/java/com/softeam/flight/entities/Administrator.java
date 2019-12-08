package com.softeam.flight.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ST_ADMINISTRATOR")  
@PrimaryKeyJoinColumn(name = "id")
public class Administrator extends Passenger {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_admin")
	private int idAdmin;
	@Column(name = "password_admin")
	private char passwordAdmin;
	
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

public char getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(char passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	
	
	

}
