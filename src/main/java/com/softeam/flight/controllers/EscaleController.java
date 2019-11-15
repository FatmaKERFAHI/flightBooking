package com.softeam.flight.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeam.flight.services.EscaleService;

public class EscaleController implements EscaleService{
	@Autowired
	private EscaleService escale;

}
