package com.softeam.flight.services;

import java.util.List;

import com.softeam.flight.entities.Flight;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;

public interface FlightService {
	
	List<Flight> getFlightsByWhere(String departureDate, String arrivalDate, 
			int flightFrom, int flightTo, ClassVol classVol, TypeVol typeVol);
	
	Flight saveFlight(Flight flight);
}
