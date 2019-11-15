package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.softeam.flight.entities.Reservation;

public interface ReservationReository extends CrudRepository<Reservation, String> {
	@Query("SELECT r.idReserv FROM Reservation r")
	String getidReserv();

}
