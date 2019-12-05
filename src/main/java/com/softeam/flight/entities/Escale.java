package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
public class Escale implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idEscale;
	private Date EDeparturDate;
	private Date EArrivalDate;
	private Date EDepartureHour;
	private Date EArrivalHour;
	
	public Escale()
	{}
	public Escale(int idEscale, Date eDeparturDate, Date eArrivalDate, Date eDepartureHour, Date eArrivalHour) {
		super();
		this.idEscale = idEscale;
		EDeparturDate = eDeparturDate;
		EArrivalDate = eArrivalDate;
		EDepartureHour = eDepartureHour;
		EArrivalHour = eArrivalHour;
	}
	public int getIdEscale() {
		return idEscale;
	}
	public void setIdEscale(int idEscale) {
		this.idEscale = idEscale;
	}
	public Date getEDeparturDate() {
		return EDeparturDate;
	}
	public void setEDeparturDate(Date eDeparturDate) {
		EDeparturDate = eDeparturDate;
	}
	public Date getEArrivalDate() {
		return EArrivalDate;
	}
	public void setEArrivalDate(Date eArrivalDate) {
		EArrivalDate = eArrivalDate;
	}
	public Date getEDepartureHour() {
		return EDepartureHour;
	}
	public void setEDepartureHour(Date eDepartureHour) {
		EDepartureHour = eDepartureHour;
	}
	public Date getEArrivalHour() {
		return EArrivalHour;
	}
	public void setEArrivalHour(Date eArrivalHour) {
		EArrivalHour = eArrivalHour;
	}

}
