package com.softeam.flight.services;
import java.util.List;
import java.util.Optional;

import com.softeam.flight.entities.Country;

/**
 * The Interface CountryService.
 * @author Fatma KERFAHI
 */
public interface CountryService {
	
	/**
	 * Gets the all country.
	 *
	 * @return the all country
	 */
	List<Country> getAllCountry();
	
	/**
	 * Save airport.
	 *
	 * @param Country the country
	 * @return the country
	 */
	Country saveAirport(Country Country);
	
	/**
	 * Find by id.
	 *
	 * @param idCountry the id country
	 * @return the optional
	 */
	Optional<Country> findById(int idCountry);
	
}