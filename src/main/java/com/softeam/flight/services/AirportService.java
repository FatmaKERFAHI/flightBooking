package com.softeam.flight.services;
import java.util.List;
import java.util.Optional;
import com.softeam.flight.entities.Airport;
public interface AirportService {
	
	List<Airport> getAllAiports();
	Airport saveAirport(Airport Airport);

	Optional<Airport> findById(int idAirport);
	}
