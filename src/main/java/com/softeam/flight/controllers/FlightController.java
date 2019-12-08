package com.softeam.flight.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softeam.flight.entities.Flight;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;
import com.softeam.flight.services.FlightService;

import io.swagger.annotations.ApiOperation;


// TODO: Auto-generated Javadoc
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
	  
	
	@PostMapping(value= "/save")
	@ApiOperation(value = "Save flight", response = Flight.class, responseContainer = "ResponseEntity")
	public ResponseEntity<Flight> createDeveloper(@RequestBody Flight flight) {
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
			@RequestParam(value="flightFrom", required=true) int flightFrom,
			@RequestParam(value="flightTo", required=true) int flightTo,
			@RequestParam(value="classVol", required=false) ClassVol classVol,
			@RequestParam(value="typeVol", required=false) TypeVol typeVol) {
		List<Flight> flights = flightService.getFlightsByWhere(departureDate, arrivalDate, flightFrom, flightTo, classVol, typeVol) ;
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK) ;
	}

}
