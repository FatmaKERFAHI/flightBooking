package com.softeam.flight.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {
	@Query("SELECT f.idFlight FROM Flight f")
	String getIdFlight();
}
