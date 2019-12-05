package com.softeam.flight.services;
import java.util.List;
import java.util.Optional;

import com.softeam.flight.entities.Country;

public interface CountryService {
	
	List<Country> getAllCountry();
	Country saveAirport(Country Country);
Optional<Country> findById(int idCountry);
	
}