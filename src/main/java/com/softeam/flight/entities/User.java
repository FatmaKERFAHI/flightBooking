package com.softeam.flight.entities;

import java.io.Serializable;
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
 * The Class User.
 */
@Entity
public class User extends Passenger implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The username. */
	//Attributs
	private String username;
	
	/** The password. */
	private String password;
	
	/** The roles. */
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
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
	 * Instantiates a new user.
	 */
	//Constructeur vide
	public User() {
		super();
	}
	
	//Constructeur avec tous les elements
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles the roles
	 */
	public User(String username, String password, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	//Get & Set
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * To string.
	 *
	 * @return the string
	 */
	//To String
	@Override
	public String toString() {
		return "Customer [ password=" + password + "]";
	}
	
	//@Table(name = "ST_USERS")
	

}//Fin User
