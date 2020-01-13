package com.softeam.flight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softeam.flight.entities.Flight;
import com.softeam.flight.entities.Reservation;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
	@Query("SELECT r.idReservation FROM Reservation r")
	String getidReservation();
}
