package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.AirCompany;

public interface AirCompanyRepository extends JpaRepository<AirCompany, String> {
	@Query("SELECT a.id FROM AirCompany a")
	String getIdAirCompany(); 
	
}
