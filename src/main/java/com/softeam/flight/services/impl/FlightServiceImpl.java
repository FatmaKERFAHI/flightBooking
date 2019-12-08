package com.softeam.flight.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Flight;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;
import com.softeam.flight.repositories.FlightRepository;
import com.softeam.flight.services.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Flight> getFlightsByWhere(String departureDate, String arrivalDate, 
			int flightFrom, int flightTo, ClassVol classVol, TypeVol typeVol) {
		return flightRepository.getFlightsByWhere(departureDate, arrivalDate, flightFrom, flightTo, classVol, typeVol);
	}
	
	public Flight saveFlight(Flight flight) {
		flightRepository.save(flight);
		return flight;
	}
}
