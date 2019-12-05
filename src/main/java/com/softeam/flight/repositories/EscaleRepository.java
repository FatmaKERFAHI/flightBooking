package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeam.flight.entities.Escale;


public interface EscaleRepository extends JpaRepository<Escale, String> {
	@Query("SELECT e.idEscale FROM Escale e")
	String getIdEscale();

}
