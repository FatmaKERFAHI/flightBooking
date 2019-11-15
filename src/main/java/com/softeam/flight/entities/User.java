package com.softeam.flight.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ST_USER")
@PrimaryKeyJoinColumn(name = "id")
public class User extends Passenger {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Attributs
	@Column(name = "id_user")
	private int idUser;
	@Column(name = "password_user")
	private char passwordUser;
	
	//Constructeur vide
	public User() {
		super();
	}
	
	//Constructeur avec tous les elements
	public User(int idUser, char passwordUser) {
		super();
		this.idUser = idUser;
		this.passwordUser = passwordUser;
	}
	
	//Get & Set
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public char getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(char passwordUser) {
		this.passwordUser = passwordUser;
	}
	
	
	

}//Fin User
