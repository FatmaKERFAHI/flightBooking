package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

/*@PrimaryKeyJoinColumn(name = "idReserv")*/
public class Reservation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idReserv;
	private Date DateReserv;
	ArrayList<Passenger> passgr = new ArrayList<Passenger>();
	public Reservation()
	{}
	public Reservation(int idReserv, Date dateReserv, ArrayList<Passenger> passgr) {
		super();
		this.idReserv = idReserv;
		DateReserv = dateReserv;
		this.passgr = passgr;
	}
	
	public int getIdReserv() {
		return idReserv;
	}
	public void setIdReserv(int idReserv) {
		this.idReserv = idReserv;
	}
	public Date getDateReserv() {
		return DateReserv;
	}
	public void setDateReserv(Date dateReserv) {
		DateReserv = dateReserv;
	}
	public ArrayList<Passenger> getPassgr() {
		return passgr;
	}
	public void setPassgr(ArrayList<Passenger> passgr) {
		this.passgr = passgr;
	}
	@Override
	public String toString() {
		return "Reservation [idReserv=" + idReserv + ", DateReserv=" + DateReserv + "]";
	}
	
	
	
		

}