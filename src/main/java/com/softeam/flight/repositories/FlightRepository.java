package com.softeam.flight.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.softeam.flight.entities.Flight;

public interface FlightRepository extends CrudRepository<Flight, String> {
	@Query("SELECT f.idFlight FROM Flight f")
	String getIdFlight();
}
