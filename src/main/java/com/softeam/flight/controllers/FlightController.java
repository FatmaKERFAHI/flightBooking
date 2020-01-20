package com.softeam.flight.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softeam.flight.entities.Airport;
import com.softeam.flight.entities.Country;
import com.softeam.flight.entities.Flight;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;
import com.softeam.flight.services.AirportService;
import com.softeam.flight.services.CountryService;
import com.softeam.flight.services.FlightService;

import io.swagger.annotations.ApiOperation;


/**
 * The Class FlightController.
 * @author Fatma KERFAHI
 */


@CrossOrigin
@RestController
@RequestMapping(value = "/flight")
public class FlightController {
	
	/** The flight service. */
	@Autowired
	private FlightService flightService;
	
	/** The country service. */
	@Autowired
	private AirportService airportService;
	
	/**
	 * Gets the all aeroports.
	 *
	 * @return the all aeroports
	 */
	@GetMapping(value = "/airports")
	public ResponseEntity<List<Airport>> getAllAeroports() {
		List<Airport> allAirports = airportService.getAllAirports();
        return new ResponseEntity<List<Airport>>(allAirports, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/fetchFlight/{flightId}")
	public ResponseEntity<Flight> getFlightById(@PathVariable("flightId") String flightId) {
		Flight flight = flightService.findById(flightId);
        return new ResponseEntity<Flight>(flight, HttpStatus.OK) ;
	}
	
	/**
	 * Creates the flight.
	 *
	 * @param flight the flight
	 * @return the response entity
	 */
	@PostMapping(value= "/save")
	@ApiOperation(value = "Save flight", response = Flight.class, responseContainer = "ResponseEntity")
	public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
		Flight savedFlight = flightService.saveFlight(flight);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idFlight}")
				.buildAndExpand(savedFlight.getIdFlight()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	/**
	 * Find flights.
	 *
	 * @param departureDate the departure date
	 * @param arrivalDate the arrival date
	 * @param flightFrom the flight from
	 * @param flightTo the flight to
	 * @param classVol the class vol
	 * @param typeVol the type vol
	 * @return the response entity
	 */
	@GetMapping(value= "/search")
	public ResponseEntity<List<Flight>> findFlights(
			@RequestParam(value="departureDate", required=true) @DateTimeFormat(pattern = "yyyy-MM-dd") String departureDate,
			@RequestParam(value="arrivalDate", required=true)  @DateTimeFormat(pattern = "yyyy-MM-dd") String arrivalDate,
			@RequestParam(value="flightFrom", required=true) String flightFrom,
			@RequestParam(value="flightTo", required=true ) String flightTo,
			@RequestParam(value="classVol", required=false) ClassVol classVol,
			@RequestParam(value="typeVol", required=false) TypeVol typeVol) {
		List<Flight> flights = flightService.getFlightsByWhere(departureDate, arrivalDate, flightFrom, flightTo, classVol, typeVol) ;
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK) ;
	}

}
