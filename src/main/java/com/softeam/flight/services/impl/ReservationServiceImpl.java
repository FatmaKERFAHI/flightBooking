package com.softeam.flight.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Reservation;
import com.softeam.flight.repositories.ReservationRepository;
import com.softeam.flight.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
		return reservation;
	}
	
	public List<Reservation> getAllReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}

}
