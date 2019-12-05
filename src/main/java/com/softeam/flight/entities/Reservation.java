package com.softeam.flight.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int idReserv;
	private Date DateReserv;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private Passenger passgr;

	
	public Reservation() {
	}

	public Reservation(int idReserv, Date dateReserv, Passenger passgr) {
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

	public Passenger getPassgr() {
		return passgr;
	}

	public void setPassgr(Passenger passgr) {
		this.passgr = passgr;
	}

	@Override
	public String toString() {
		return "Reservation [idReserv=" + idReserv + ", DateReserv=" + DateReserv + ", passgr=" + passgr + "]";
	}


}