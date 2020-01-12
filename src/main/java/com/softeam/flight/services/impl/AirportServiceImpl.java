package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softeam.flight.entities.Airport;
import com.softeam.flight.repositories.AirportRepository;
import com.softeam.flight.services.AirportService;

/**
 * The Class AirportServiceImpl.
 * @author Fatma KERFAHI
 */
@Service
public class AirportServiceImpl implements AirportService {
	
	/** The airport repository. */
	@Autowired
	private AirportRepository airportRepository;

	/**
	 * Gets the all aiports.
	 *
	 * @return the all aiports
	 */
	@Override
	public List<Airport> getAllAirports() {
		return (List<Airport>) airportRepository.findAll();
	}

	/**
	 * Save airport.
	 *
	 * @param Airport the airport
	 * @return the airport
	 */
	@Override
	public Airport saveAirport(Airport Airport) {
		airportRepository.save(Airport);
		return Airport;
	}

	/**
	 * Find by id.
	 *
	 * @param idAirport the id airport
	 * @return the optional
	 */
	@Override
	public Optional<Airport> findById(String code) {
		return airportRepository.findById(code) ;
	}

	
}
