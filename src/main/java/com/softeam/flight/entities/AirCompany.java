package com.softeam.flight.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * The Class AirCompany.
 */
@Data
@Entity
public class AirCompany implements Serializable {
  
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id air company. */
	@Id
	private int idAirCompany ;
	
	/** The name. */
	@Column(name = "name")
	private String name;

	/**
	 * Gets the id air company.
	 *
	 * @return the id air company
	 */
	public int getIdAirCompany() {
		return idAirCompany;
	}

	/**
	 * Sets the id air company.
	 *
	 * @param idAirCompany the new id air company
	 */
	public void setIdAirCompany(int idAirCompany) {
		this.idAirCompany = idAirCompany;
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
	

}
