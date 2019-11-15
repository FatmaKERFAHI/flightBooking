package com.softeam.flight.entities;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ST_PASSENGER")
/*@PrimaryKeyJoinColumn(name = "id")*/
public class Passenger implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Attributs
	@Id	
	@Column(name = "id_passenger")
	private int idPassenger;
	@Column(name = "kind")
	private Kind kind;
	@Column(name = "name")
	private String name;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "age")
	private Date age;
	@Column(name = "num_passport")
	private char numPassport;
	@Column(name = "num_phone")
	private int numPhone;
	@Column(name = "mail")
	private char mail;

	
	//constucteur vide
	public Passenger() {
		super();
	}
	
	//constructeur avec plusieurs elements
	public Passenger(int idPassenger, Kind kind, String name, String firstName, Date age, char numPassport, int numPhone,
			char mail) {
		super();
		this.idPassenger = idPassenger;
		this.kind = kind;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
		this.numPassport = numPassport;
		this.numPhone = numPhone;
		this.mail = mail;
		
	}

	
	//Get & Set
	public int getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(int idPassenger) {
		this.idPassenger = idPassenger;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirst_Nme(String firstName) {
		this.firstName = firstName;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}

	public char getNumPassport() {
		return numPassport;
	}

	public void setNumPassport(char numPassport) {
		this.numPassport = numPassport;
	}

	public int getNumPhone() {
		return numPhone;
	}

	public void setNumPhone(int numPhone) {
		this.numPhone = numPhone;
	}

	public char getMail() {
		return mail;
	}

	public void setMail(char mail) {
		this.mail = mail;
	}


	
	//To string
	@Override
	public String toString() {
		return "Passenger [idPassenger=" + idPassenger + ", kind=" + kind + ", name=" + name + ", firstName=" + firstName + ", age="
				+ age + ", numNassport=" + numPassport + ", numPhone=" + numPhone + ", mail=" + mail + "]";
	}
	
	
	
		
	

}//fin Passenger
