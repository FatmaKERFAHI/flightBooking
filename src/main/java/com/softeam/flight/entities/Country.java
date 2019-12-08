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

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

/**
 * The Class Country.
 * @author Fatma KERFAHI
 */


@Data
@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The iso code. */
	@Id
	private String isoCode;
	
	/** The name. */
	private String name;
	
	/** The airports. */
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Airport> airports = new ArrayList<Airport>();

	/**
	 * Gets the iso code.
	 *
	 * @return the iso code
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * Sets the iso code.
	 *
	 * @param isoCode the new iso code
	 */
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the airports.
	 *
	 * @return the airports
	 */
	public List<Airport> getAirports() {
		return airports;
	}

	/**
	 * Sets the airports.
	 *
	 * @param airports the new airports
	 */
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}
