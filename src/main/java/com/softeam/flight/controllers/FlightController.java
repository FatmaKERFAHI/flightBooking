package com.softeam.flight.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeam.flight.services.FlightService;


@CrossOrigin
@RestController
@RequestMapping(value = "/flight")
public class FlightController {
	@Autowired
	private FlightService flightservices;
	
}
