package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.Reservation;

public interface ReservationReository extends JpaRepository<Reservation, String> {
	@Query("SELECT r.idReserv FROM Reservation r")
	String getidReserv();

}
