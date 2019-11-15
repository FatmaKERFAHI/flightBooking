package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
/*@PrimaryKeyJoinColumn(name = "idFlight")*/
public class Flight implements Serializable 
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	private int idFlight;
	private Date DeparturDate;
	private Date ArrivalDate;
	private Date DepartureHour;
	private Date ArrivalHour;
	private int price;
	private TypeVol Type;
	private int NumPlaces;
	
	public Flight() {
		super();
	}
	public Flight(Date departurDate, Date arrivalDate, Date departureHour, Date arrivalHour, int price, TypeVol type,
			int numPlaces) 
	{
		super();
		DeparturDate = departurDate;
		ArrivalDate = arrivalDate;
		DepartureHour = departureHour;
		ArrivalHour = arrivalHour;
		this.price = price;
		Type = type;
		NumPlaces = numPlaces;
		
	}
	public Date getDeparturDate() {
		return DeparturDate;
	}
	public void setDeparturDate(Date departurDate) {
		DeparturDate = departurDate;
	}
	public Date getArrivalDate() {
		return ArrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		ArrivalDate = arrivalDate;
	}
	public Date getDepartureHour() {
		return DepartureHour;
	}
	public void setDepartureHour(Date departureHour) {
		DepartureHour = departureHour;
	}
	public Date getArrivalHour() {
		return ArrivalHour;
	}
	public void setArrivalHour(Date arrivalHour) {
		ArrivalHour = arrivalHour;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public TypeVol getType() {
		return Type;
	}
	public void setType(TypeVol type) {
		Type = type;
	}
	public int getNumPlaces() {
		return NumPlaces;
	}
	public void setNumPlaces(int numPlaces) {
		NumPlaces = numPlaces;
	}
	@Override
	public String toString() {
		return "Flight [DeparturDate=" + DeparturDate + ", ArrivalDate=" + ArrivalDate + ", DepartureHour="
				+ DepartureHour + ", ArrivalHour=" + ArrivalHour + ", price=" + price + ", Type=" + Type
				+ ", NumPlaces=" + NumPlaces + "]";
	}
	public int getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}
	

}
