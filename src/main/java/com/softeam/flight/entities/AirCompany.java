package com.softeam.flight.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;


@Data
@Entity
public class AirCompany implements Serializable {
  
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int idAirCompany ;
	
	@Column(name = "name")
	private String name;
	
	
	public AirCompany() {
		super();
	}
	public AirCompany(int idAirCompany, String name) {
		super();
		this.idAirCompany = idAirCompany;
		this.name = name;
	}

	public int getIdAirCompany() {
		return idAirCompany;
	}

	public void setIdAirCompany(int idAirCompany) {
		this.idAirCompany = idAirCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AirCompany [idAirCompany=" + idAirCompany + ", name=" + name + "]";
	}
	

}
