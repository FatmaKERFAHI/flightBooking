package com.softeam.flight.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 *  @author Mosbah Mohamed Ali
 * The Class Administrator.
 */
@Entity

public class Administrator extends Passenger {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user name. */
	// Attributs
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The roles. */
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
	private List <Role> roles = new ArrayList<Role>();
	
	/**
	 * Adds the.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean add(Role e) {
		return roles.add(e);
	}
	
	/**
	 * Removes the.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean remove(Object o) {
		return roles.remove(o);
	}

	/**
	 * Instantiates a new administrator.
	 */
	// Constructeurs vide
	public Administrator() {
		super();
	}
	
	/**
	 * Instantiates a new administrator.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param roles the roles
	 */
	public Administrator(String userName, String password, List<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	
	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Administrator [userName=" + userName + ", password=" + password + ", roles=" + roles + "]";
	}

	// Constructeurs avec elements
	
	// To String

	
	//@Table(name = "ST_ADMINISTRATOR")
}// Fin Administrateur
