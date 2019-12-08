package com.softeam.flight.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
public class Airport implements Serializable {

	private static final long serialVersionUID = 1L;

	public Airport() {
		super();
	}

	public Airport(int idAirport, String name, int code, Country country) {
		super();
		this.idAirport = idAirport;
		this.name = name;
		this.code = code;
		this.country = country;
	}

	/**
	 * 
	 */
	@Id
	private int idAirport;
	private String name;
	private int code;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Country country;

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

	public int getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(int idAirport) {
		this.idAirport = idAirport;
	}

}
