package com.softeam.flight.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.repositories.FlightRepository;
import com.softeam.flight.services.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightRepository flight;
}
