package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Escale implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int idEscale;
	private Date EDeparturDate;
	private Date EArrivalDate;
	
	public Escale() {
		super();
	}
	public Escale(int idEscale, Date eDeparturDate, Date eArrivalDate) {
		super();
		this.idEscale = idEscale;
		EDeparturDate = eDeparturDate;
		EArrivalDate = eArrivalDate;
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
	@Override
	public String toString() {
		return "Escale [idEscale=" + idEscale + ", EDeparturDate=" + EDeparturDate + ", EArrivalDate=" + EArrivalDate
				+ "]";
	}
	

}
