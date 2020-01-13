package com.softeam.flight.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;

// TODO: Auto-generated Javadoc
/**
 *  @author Mosbah Mohamed Ali
 * The Class Passenger.
 */
@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Passenger implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	// Attributs

	/** The id passenger. */
	@Id
	@GeneratedValue
	private long idPassenger;
	
	/** The name. */
	private String name;
	
	/** The first name. */
	private String firstName;
	//@Temporal(TemporalType.TIMESTAMP)
	/** The age. */
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date age;
	
	/** The num passport. */
	private String numPassport;
	
	/** The num phone. */
	private String numPhone;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new passenger.
	 */
	// constucteur vide
	public Passenger() {
		super();
	}

	/**
	 * Instantiates a new passenger.
	 *
	 * @param name the name
	 * @param firstName the first name
	 */
	// constructeur aven nom et prenom
	public Passenger(String name, String firstName) {
		super();
		this.name = name;
		this.firstName = firstName;
	}

	/**
	 * Instantiates a new passenger.
	 *
	 * @param idPassenger the id passenger
	 * @param name the name
	 * @param firstName the first name
	 * @param age the age
	 * @param numPassport the num passport
	 * @param numPhone the num phone
	 * @param email the email
	 */
	// constructeur avec plusieurs elements
	public Passenger(long idPassenger, String name, String firstName, Date age, String numPassport, String numPhone,
			String email) {
		super();
		this.idPassenger = idPassenger;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
		this.numPassport = numPassport;
		this.numPhone = numPhone;
		this.email = email;

	}

	/**
	 * Gets the id passenger.
	 *
	 * @return the id passenger
	 */
	// Get & Set
	public long getIdPassenger() {
		return idPassenger;
	}

	/**
	 * Sets the id passenger.
	 *
	 * @param idPassenger the new id passenger
	 */
	public void setIdPassenger(long idPassenger) {
		this.idPassenger = idPassenger;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Date getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Date age) {
		this.age = age;
	}

	/**
	 * Gets the num passport.
	 *
	 * @return the num passport
	 */
	public String getNumPassport() {
		return numPassport;
	}

	/**
	 * Sets the num passport.
	 *
	 * @param numPassport the new num passport
	 */
	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}

	/**
	 * Gets the num phone.
	 *
	 * @return the num phone
	 */
	public String getNumPhone() {
		return numPhone;
	}

	/**
	 * Sets the num phone.
	 *
	 * @param numPhone the new num phone
	 */
	public void setNumPhone(String numPhone) {
		this.numPhone = numPhone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the e email.
	 *
	 * @param email the new e email
	 */
	public void seteEmail(String email) {
		this.email = email;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	// To string
	@Override
	public String toString() {
		return "Passenger [idPassenger=" + idPassenger + ", name=" + name + ", firstName=" + firstName + ", age=" + age
				+ ", numNassport=" + numPassport + ", numPhone=" + numPhone + ", email=" + email + "]";
	}

	/**
	 * Or else.
	 *
	 * @param object the object
	 * @return the passenger
	 */
	public Passenger orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Table(name = "ST_PASSENGERS")

}// fin Passenger
