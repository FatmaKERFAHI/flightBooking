package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
	@Query("SELECT a.id FROM Country a")
	String getIdCountry(); 
}
