package com.softeam.flight.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 *  @author Mosbah Mohamed Ali
 * The Class Role.
 */
@Entity
public class Role {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

		/** The id. */
		// Attributs
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		/** The titre. */
		private String titre;
	
	
	

	/**
	 * Instantiates a new role.
	 */
	// Constructeurs vide"id
	public Role() {
		super();
	}

	/**
	 * Instantiates a new role.
	 *
	 * @param titre the titre
	 */
	// Constructeurs avec elements
	public Role(String titre) {
		super();
		this.titre = titre;
	}
	

	/**
	 * Instantiates a new role.
	 *
	 * @param id the id
	 * @param titre the titre
	 */
	public Role(long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	/**
	 * Gets the titre.
	 *
	 * @return the titre
	 */
	// Get & Set
	public String getTitre() {
		return titre;
	}

	/**
	 * Sets the titre.
	 *
	 * @param titre the new titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", titre=" + titre + "]";
	}

	

	//@Table(name = "ST_ROLES")
	

}// Fin
