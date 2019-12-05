package com.softeam.flight.services.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Airport;
import com.softeam.flight.repositories.AirportRepository;
import com.softeam.flight.services.AirportService;
@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private AirportRepository repository;

	@Override
	public List<Airport> getAllAiports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport saveAirport(Airport Airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Airport> findById(int idAirport) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
