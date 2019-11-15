package com.softeam.flight.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeam.flight.repositories.ReservationReository;
import com.softeam.flight.services.ReservationServices;

public class ReservationServiceImpl implements ReservationServices{
	@Autowired
	private ReservationReository reservation;

}
