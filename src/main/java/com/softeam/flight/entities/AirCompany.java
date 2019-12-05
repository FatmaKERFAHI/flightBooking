package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
/*@PrimaryKeyJoinColumn(name = "idAirCompany")*/
public class AirCompany implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Id
	private int idAirCompany ;
	@Column(name = "name")
	private String name;
	
	
	public AirCompany(int idAirCompany, String name) {
		super();
		this.idAirCompany = idAirCompany;
		this.name = name;
	}
	
	
	public int getidAirCompany() {
		return idAirCompany;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the idAirCompany
	 */
	public int getIdAirCompany() {
		return idAirCompany;
	}
	/**
	 * @param idAirCompany the idAirCompany to set
	 */
	public void setIdAirCompany(int idAirCompany) {
		this.idAirCompany = idAirCompany;
	}
	
	@Override
	public String toString() {
		return "AirCompany [idAirCompany=" + idAirCompany + ", name=" + name +"]";
	}



}
