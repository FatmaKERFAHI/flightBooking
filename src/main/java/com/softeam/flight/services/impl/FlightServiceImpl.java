package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.Airport;
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
			String flightFrom, String flightTo, ClassVol classVol, TypeVol typeVol) {
		return flightRepository.getFlightsByWhere(departureDate, arrivalDate, flightFrom, flightTo, classVol, typeVol);
	}
	
	public Flight saveFlight(Flight flight) {
		flightRepository.save(flight);
		return flight;
	}
	
	@Override
	public Flight findById(String code) {
		Optional<Flight> flight = flightRepository.findById(code);
		if(flight.isPresent()) {
			return flight.get();
		} else {
			return null;
		}
	}
}
