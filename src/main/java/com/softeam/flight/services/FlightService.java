package com.softeam.flight.services;

import java.util.List;
import com.softeam.flight.entities.Flight;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;

/**
 * The Interface FlightService.
 * @author Fatma KERFAHI
 */
public interface FlightService {
	
	/**
	 * Gets the flights by where.
	 *
	 * @param departureDate the departure date
	 * @param arrivalDate the arrival date
	 * @param flightFrom the flight from
	 * @param flightTo the flight to
	 * @param classVol the class vol
	 * @param typeVol the type vol
	 * @return the flights by where
	 */
	List<Flight> getFlightsByWhere(String departureDate, String arrivalDate, String flightFrom, String flightTo, ClassVol classVol, TypeVol typeVol);
	
	/**
	 * Save flight.
	 *
	 * @param flight the flight
	 * @return the flight
	 */
	Flight saveFlight(Flight flight);
	
	/**
	 * Find by id.
	 *
	 * @param code the code
	 * @return the flight
	 */
	Flight findById(String code);
}
