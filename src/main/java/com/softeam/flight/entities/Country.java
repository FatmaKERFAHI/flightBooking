package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable{

	


	private static final long serialVersionUID = 1L;
	@Id
	private int idCountry;
	private String name;
	private int code;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Airport> airpts = new ArrayList<Airport>();
	
	
	public Country(int idCountry, String name, int code, List<Airport> airpts) {
		super();
		this.idCountry = idCountry;
		this.name = name;
		this.code = code;
		this.airpts = airpts;
	}

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
		return "Country [idCountry=" + idCountry + ", name=" + name + ", code=" + code + ", airpts=" + airpts + "]";
	}



	/**
	 * @return the airpts
	 */
	public List<Airport> getAirpts() {
		return airpts;
	}



	/**
	 * @param airpts the airpts to set
	 */
	public void setAirpts(List<Airport> airpts) {
		this.airpts = airpts;
	}
	

}
