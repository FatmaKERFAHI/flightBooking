package com.softeam.flight.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ST_ADMINISTRATOR")  //si non mise le nom de la class sera prise par defaut
@PrimaryKeyJoinColumn(name = "id")
public class Administrator extends Passenger {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Attributs
	@Column(name = "id_admin")
	private int idAdmin;
	@Column(name = "password_admin")
	private char passwordAdmin;
	
	//Constructeurs vide
	public Administrator() {
		super();
	}
	
	//Constructeurs avec elements
	public Administrator(int idAdmin, char passwordAdmin) {
		super();
		this.idAdmin = idAdmin;
		this.passwordAdmin = passwordAdmin;
	}

	//Get & Set
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

	//To String
	@Override
	public String toString() {
		return "Administrator [idAdmin=" + idAdmin + ", passwordAdmin=" + passwordAdmin + "]";
	}
	
	

}//Fin Administrateur
