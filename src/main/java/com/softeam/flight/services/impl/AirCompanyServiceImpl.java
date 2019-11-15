package com.softeam.flight.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.AirCompany;
import com.softeam.flight.repositories.AirCompanyRepository;
import com.softeam.flight.services.AirCompanyService;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

	@Autowired
	private AirCompanyRepository repository;
	
	public List<AirCompany> getAllAirCompany() {
		return (List<AirCompany>) repository.findAll();
	}

	public AirCompany saveCustomer(AirCompany airCompany) {
		repository.save(airCompany);
		return airCompany;
	}

	public Optional<AirCompany> findById(int idAirCompany) {
		return repository.findById(String.valueOf(idAirCompany)) ;
	}

	@Override
	public AirCompany saveAirCompany(AirCompany airCompany) {
		// TODO Auto-generated method stub
		return null;
	}

}