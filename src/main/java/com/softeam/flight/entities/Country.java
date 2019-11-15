package com.softeam.flight.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")

public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idCountry;
	private String name;
	private int code;
	
	public Country(String name, int code, int idCountry) {
		super();
		this.name = name;
		this.code = code;
		this.idCountry = idCountry;
	}
	
	
	
	//Constructeur
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getter&Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
		
	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + "]";
	}
	

}
