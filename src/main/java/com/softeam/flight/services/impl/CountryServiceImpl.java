package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Country;
import com.softeam.flight.repositories.CountryRepository;
import com.softeam.flight.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	
	@Autowired
	private CountryRepository repository;

	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country saveAirport(Country Country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Country> findById(int idCountry) {
		// TODO Auto-generated method stub
		return null;
	}
}