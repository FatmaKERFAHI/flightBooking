package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;

import lombok.Data;

/**
 * The Class Flight.
 * @author Ibtihel
 */


@Data
@Entity
public class Flight implements Serializable 
{

	public Flight(String idFlight, Date departureDate, Date arrivalDate, double price, TypeVol typeVol,
			ClassVol classVol, int numPlaces, Airport departure, Airport arrival, AirCompany airCompany) {
		super();
		this.idFlight = idFlight;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.price = price;
		this.typeVol = typeVol;
		this.classVol = classVol;
		this.numPlaces = numPlaces;
		this.departure = departure;
		this.arrival = arrival;
		this.airCompany = airCompany;
	}
	public Flight() {
		super();
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id flight. */
	@Id
	private String idFlight;
	
	/** The departure date. */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date departureDate;
	
	/** The arrival date. */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date arrivalDate;
	
	/** The price. */
	private double price;
	
	/** The typeVol */
	@Enumerated(EnumType.STRING)
	private TypeVol typeVol;
	
	@Enumerated(EnumType.STRING)
	private ClassVol classVol;
	
	/** The num places. */
	private int numPlaces;
	
	/**  The escale. */
	
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.ALL}, fetch = FetchType.EAGER)
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Airport departure;
	
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.ALL }, fetch = FetchType.EAGER)
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Airport arrival;
	
	/**  The air Company. */
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.ALL}, fetch = FetchType.EAGER)
	private AirCompany airCompany;


	/**
	 * Gets the id flight.
	 *
	 * @return the id flight
	 */
	public String getIdFlight() {
		return idFlight;
	}

	/**
	 * Sets the id flight.
	 *
	 * @param idFlight the new id flight
	 */
	public void setIdFlight(String idFlight) {
		this.idFlight = idFlight;
	}

	/**
	 * Gets the departure date.
	 *
	 * @return the departure date
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * Sets the departure date.
	 *
	 * @param departureDate the new departure date
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * Gets the arrival date.
	 *
	 * @return the arrival date
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * Sets the arrival date.
	 *
	 * @param arrivalDate the new arrival date
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public TypeVol getTypeVol() {
		return typeVol;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setTypeVol(TypeVol typeVol) {
		this.typeVol = typeVol;
	}

	public ClassVol getClassVol() {
		return classVol;
	}

	public void setClassVol(ClassVol classVol) {
		this.classVol = classVol;
	}

	/**
	 * Gets the num places.
	 *
	 * @return the num places
	 */
	public int getNumPlaces() {
		return numPlaces;
	}

	/**
	 * Sets the num places.
	 *
	 * @param numPlaces the new num places
	 */
	public void setNumPlaces(int numPlaces) {
		this.numPlaces = numPlaces;
	}

	/**
	 * Gets the escale.
	 *
	 * @return the escale
	 */

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getArrival() {
		return arrival;
	}

	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}


	/**
	 * Gets the air company.
	 *
	 * @return the air company
	 */
	public AirCompany getAirCompany() {
		return airCompany;
	}

	/**
	 * Sets the air company.
	 *
	 * @param airCompany the new air company
	 */
	public void setAirCompany(AirCompany airCompany) {
		this.airCompany = airCompany;
	}

	@Override
	public String toString() {
		return "Flight [idFlight=" + idFlight + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate
				+ ", price=" + price + ", typeVol=" + typeVol + ", classVol=" + classVol + ", numPlaces=" + numPlaces
				+ ", departure=" + departure + ", arrival=" + arrival + ", airCompany=" + airCompany + "]";
	}

}
