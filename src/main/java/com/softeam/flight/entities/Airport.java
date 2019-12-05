package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Airport implements Serializable{
	
	
	/**
	 * 
	 */
	@Id
	private int idAirport;
	private static final long serialVersionUID = 1L;
	private String name;
	private int code;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private	Country ctr; 
	public Airport(int idAirport, String name, int code, Country ctr) {
		super();
		this.idAirport = idAirport;
		this.name = name;
		this.code = code;
		this.ctr = ctr;
	}

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
		return "Airport [idAirport=" + idAirport + ", name=" + name + ", code=" + code + ", ctr=" + ctr + "]";
	}

	public int getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(int idAirport) {
		this.idAirport = idAirport;
	}

	/**
	 * @return the ctr
	 */
	public Country getCtr() {
		return ctr;
	}

	/**
	 * @param ctr the ctr to set
	 */
	public void setCtr(Country ctr) {
		this.ctr = ctr;
	}		
	

}
