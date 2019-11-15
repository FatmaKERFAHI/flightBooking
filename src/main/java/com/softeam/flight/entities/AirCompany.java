package com.softeam.flight.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
/*@PrimaryKeyJoinColumn(name = "idAirCompany")*/
public class AirCompany implements Serializable {
  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idAirCompany ;
	@Column(name = "name")
	private String name;
	
	public int getidAirCompany() {
		return idAirCompany;
	}
	public void setId(int id) {
		this.idAirCompany = idAirCompany;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 




}
