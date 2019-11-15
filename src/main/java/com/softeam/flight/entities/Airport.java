package com.softeam.flight.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity

public class Airport implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int code;
	@Id
	private int idAirport;
	
	
	public Airport(String name,int code, int idAirport) {
		super();
		this.name = name;
		this.code = code;
		this.idAirport =idAirport;
		
	}

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "Airport [name=" + name + ", code=" + code + "]";
	}

	public int getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(int idAirport) {
		this.idAirport = idAirport;
	}
		
	

}
