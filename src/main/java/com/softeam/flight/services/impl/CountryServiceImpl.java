package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softeam.flight.entities.Country;
import com.softeam.flight.repositories.CountryRepository;
import com.softeam.flight.services.CountryService;

/**
 * The Class CountryServiceImpl.
 * @author Fatma KERFAHI
 */
@Service
public class CountryServiceImpl implements CountryService {
	
	
	/** The country repository. */
	@Autowired
	private CountryRepository countryRepository;

	/**
	 * Gets the all country.
	 *
	 * @return the all country
	 */
	@Override
	public List<Country> getAllCountry() {
		return (List<Country>) countryRepository.findAll();
	}

	/**
	 * Save airport.
	 *
	 * @param Country the country
	 * @return the country
	 */
	@Override
	public Country saveAirport(Country Country) {
		countryRepository.save(Country);
		return Country;
	}

	/**
	 * Find by id.
	 *
	 * @param idCountry the id country
	 * @return the optional
	 */
	@Override
	public Optional<Country> findById(int idCountry) {
		return countryRepository.findById(String.valueOf(idCountry)) ;
	}
}