package com.softeam.flight.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.softeam.flight.entities.Flight;
import com.softeam.flight.enums.ClassVol;
import com.softeam.flight.enums.TypeVol;

public interface FlightRepository extends JpaRepository<Flight, String> {

	@Query("SELECT f.idFlight FROM Flight f")
	String getIdFlight();

	@Query("SELECT f FROM Flight f WHERE DATE(f.departureDate)=DATE(:departureDate) AND DATE(f.arrivalDate)=DATE(:arrivalDate) AND f.departure.idAirport=:departure "
			+ "AND f.arrival.idAirport=:arrival AND f.classVol=:classVol AND f.typeVol=:typeVol")
	List<Flight> getFlightsByWhere(@Param("departureDate") String departureDate, @Param("arrivalDate") String arrivalDate,
			@Param("departure") int departure, @Param("arrival") int arrival, @Param("classVol") ClassVol classVol,
			@Param("typeVol") TypeVol typeVol);

	@Query("SELECT f FROM Flight f WHERE DATE(f.departureDate)=DATE(:departureDate) AND DATE(f.arrivalDate)=DATE(:arrivalDate)")
	List<Flight> getFlightsByWhere(@Param("departureDate") String departureDate, @Param("arrivalDate")  String arrivalDate);

	
	@Query("SELECT f FROM Flight f WHERE DATE(f.departureDate)=DATE('2019-10-18') AND DATE(f.arrivalDate)=DATE('2019-10-20')")
	List<Flight> getFlightsByWhere();
	
	
	
	@Query("SELECT f FROM Flight f WHERE f.departure.idAirport=:departure "
			+ "AND f.arrival.idAirport=:arrival AND f.classVol=:classVol AND f.typeVol=:typeVol")
	List<Flight> getFlightsByWhere(@Param("departure") int departure, @Param("arrival") int arrival,
			@Param("classVol") ClassVol classVol, @Param("typeVol") TypeVol typeVol);
}
