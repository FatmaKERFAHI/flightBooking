package com.softeam.flight.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeam.flight.repositories.EscaleRepository;
import com.softeam.flight.services.EscaleService;

public class EscaleServiceImpl  implements EscaleService{
	@Autowired
	private EscaleRepository escale;

}
