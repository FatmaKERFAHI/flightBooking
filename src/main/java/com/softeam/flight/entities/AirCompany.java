package com.softeam.flight.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;


@Data
@Entity
public class AirCompany implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idAirCompany ;
	
	@Column(name = "name")
	private String name;

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
	

}
