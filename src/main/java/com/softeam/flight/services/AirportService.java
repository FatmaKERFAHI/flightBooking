package com.softeam.flight.services;

import java.util.List;
import java.util.Optional;
import com.softeam.flight.entities.Airport;

/**
 * The Interface AirportService.
 * @author Fatma KERFAHI
 */
public interface AirportService {
	
	/**
	 * Gets the all aiports.
	 *
	 * @return the all aiports
	 */
	List<Airport> getAllAirports();
	
	/**
	 * Save airport.
	 *
	 * @param Airport the airport
	 * @return the airport
	 */
	Airport saveAirport(Airport Airport);
	
	/**
	 * Find by id.
	 *
	 * @param idAirport the id airport
	 * @return the optional
	 */
	Optional<Airport> findById(String code);
	}
