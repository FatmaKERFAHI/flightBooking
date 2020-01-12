package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, String> {
	@Query("SELECT a.code FROM Airport a")
	String getIdAirport(); 

}
