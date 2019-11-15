package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.softeam.flight.entities.Escale;


public interface EscaleRepository extends CrudRepository<Escale, String> {
	@Query("SELECT e.idEscale FROM Escale e")
	String getIdEscale();

}
