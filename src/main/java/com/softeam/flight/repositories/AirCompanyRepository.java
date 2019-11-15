package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.softeam.flight.entities.AirCompany;

public interface AirCompanyRepository extends CrudRepository<AirCompany, String> {
	@Query("SELECT a.id FROM AirCompany a")
	String getIdAirCompany(); 
	
}
