package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


/**
 * The Class Reservation.
 *
 * @author Fatma KERFAHI
 */
@Data
@Entity
public class Reservation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id reservation. */
	@Id
	private int idReservation;

	/** The price. */
	private double price;
	
	/** The reservation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date reservationDate;

	
	/** The passenger. */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Passenger passenger;
	
	/** The flight. */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Flight flight;
	/**
	 * Gets the id reservation.
	 *
	 * @return the id reservation
	 */
	public int getIdReservation() {
		return idReservation;
	}
	
	/**
	 * Sets the id reservation.
	 *
	 * @param idReservation the new id reservation
	 */
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	
	/**
	 * Gets the passenger.
	 *
	 * @return the passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}

	/**
	 * Sets the passenger.
	 *
	 * @param passenger the new passenger
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
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
	 * Gets the flight.
	 *
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * Sets the flight.
	 *
	 * @param flight the new flight
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * Gets the reservation date.
	 *
	 * @return the reservation date
	 */
	public Date getReservationDate() {
		return reservationDate;
	}


	/**
	 * Sets the reservation date.
	 *
	 * @param reservationDate the new reservation date
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}



}