package com.softeam.flight.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softeam.flight.entities.Reservation;
import com.softeam.flight.services.ReservationService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Fatma KERFAHI.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Reservation>> getAllReservations() {
		List<Reservation> allReservations =reservationService.getAllReservations();
        return new ResponseEntity<List<Reservation>>(allReservations, HttpStatus.OK);
	}

	@PostMapping(value= "/save")
	@ApiOperation(value = "Save reservation", response = Reservation.class, responseContainer = "ResponseEntity")
	public ResponseEntity<Reservation> createFlight(@RequestBody Reservation reservation) {
		Reservation savedReservation = reservationService.saveReservation(reservation);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idReservation}")
				.buildAndExpand(savedReservation.getIdReservation()).toUri();
		return ResponseEntity.created(location).build();
	}	
}
