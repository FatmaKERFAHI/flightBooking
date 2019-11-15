package com.softeam.flight.services;

import java.util.List;
import java.util.Optional;

import com.softeam.flight.entities.AirCompany;

public interface AirCompanyService {
	List<AirCompany> getAllAirCompany();
	AirCompany saveAirCompany(AirCompany airCompany);
	Optional<AirCompany> findById(int idAirCompany);
}
