package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
/*@PrimaryKeyJoinColumn(name = "idFlight")*/
public class Flight implements Serializable 
{
	public Flight(int idFlight, Date departurDate, Date arrivalDate, Date departureHour, Date arrivalHour, int price,
			TypeVol type, int numPlaces, List<Escale> esc, Airport arport, AirCompany arcmp, Transaction trans) {
		super();
		this.idFlight = idFlight;
		DeparturDate = departurDate;
		ArrivalDate = arrivalDate;
		DepartureHour = departureHour;
		ArrivalHour = arrivalHour;
		this.price = price;
		Type = type;
		NumPlaces = numPlaces;
		this.esc = esc;
		Arport = arport;
		Arcmp = arcmp;
		this.trans = trans;
	}
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
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Escale> esc = new ArrayList<Escale>();
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Airport Arport;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private AirCompany Arcmp;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Transaction trans;
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
		return "Flight [idFlight=" + idFlight + ", DeparturDate=" + DeparturDate + ", ArrivalDate=" + ArrivalDate
				+ ", DepartureHour=" + DepartureHour + ", ArrivalHour=" + ArrivalHour + ", price=" + price + ", Type="
				+ Type + ", NumPlaces=" + NumPlaces + ", esc=" + esc + ", Arport=" + Arport + ", Arcmp=" + Arcmp
				+ ", trans=" + trans + "]";
	}
	public int getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}
	/**
	 * @return the esc
	 */
	public List<Escale> getEsc() {
		return esc;
	}
	/**
	 * @param esc the esc to set
	 */
	public void setEsc(List<Escale> esc) {
		this.esc = esc;
	}
	/**
	 * @return the arport
	 */
	public Airport getArport() {
		return Arport;
	}
	/**
	 * @param arport the arport to set
	 */
	public void setArport(Airport arport) {
		Arport = arport;
	}
	/**
	 * @return the arcmp
	 */
	public AirCompany getArcmp() {
		return Arcmp;
	}
	/**
	 * @param arcmp the arcmp to set
	 */
	public void setArcmp(AirCompany arcmp) {
		Arcmp = arcmp;
	}
	/**
	 * @return the trans
	 */
	public Transaction getTrans() {
		return trans;
	}
	/**
	 * @param trans the trans to set
	 */
	public void setTrans(Transaction trans) {
		this.trans = trans;
	}
	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Escale e) {
		return esc.add(e);
	}
	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return esc.remove(o);
	}
	

}
