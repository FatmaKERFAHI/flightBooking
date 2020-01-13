package com.softeam.flight.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeam.flight.entities.Passenger;



// TODO: Auto-generated Javadoc
/**
 * @author Mosbah Mohamed Ali
 * The Interface PassengerRepository.
 */
public interface PassengerRepository extends JpaRepository <Passenger,Long> {
	
	/**
	 * Find by name and first name.
	 *
	 * @param name the name
	 * @param firstName the first name
	 * @return the list
	 */
	List<Passenger> findByNameAndFirstName(String name, String firstName);
	
	/**
	 * Find by id passenger.
	 *
	 * @param idPassenger the id passenger
	 * @return the passenger
	 */
	Passenger findByIdPassenger(long idPassenger);


}
