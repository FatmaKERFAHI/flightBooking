package com.softeam.flight.services;

import java.util.List;
import com.softeam.flight.entities.Reservation;

public interface ReservationService {
	
	Reservation saveReservation (Reservation reservation); 
	List<Reservation> getAllReservations();

}
