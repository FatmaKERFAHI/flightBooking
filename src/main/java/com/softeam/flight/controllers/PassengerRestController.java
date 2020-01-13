/*
 * 
 */
package com.softeam.flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softeam.flight.entities.Passenger;
import com.softeam.flight.repositories.PassengerRepository;


	// TODO: Auto-generated Javadoc
/**
 * @author Mosbah Mohamed Ali
	 * The Class PassengerRestController.
	 */
	@CrossOrigin
	@RestController
	public class PassengerRestController {
		
		/** The passenger repository. */
		@Autowired
		private PassengerRepository passengerRepository;
		
		/**
		 * Gets the passengers.
		 *
		 * @return the passengers
		 */
		@GetMapping("/getallpassengers")
		public List<Passenger> getPassengers() {
			return passengerRepository.findAll();
		}

		/**
		 * Gets the passenger.
		 *
		 * @param idPassenger the id passenger
		 * @return the passenger
		 */
		@GetMapping("/getpassengers/{idPassenger}")
		public Passenger getPassenger(@PathVariable("idPassenger") long idPassenger) {
			return passengerRepository.findByIdPassenger(idPassenger).orElse(null);
		}

		/**
		 * Adds the passenger.
		 *
		 * @param passenger the passenger
		 * @return the passenger
		 */
		@PostMapping("/addpassengers")
		public Passenger addPassenger(@RequestBody Passenger passenger) {
			return passengerRepository.save(passenger);
		}

		/**
		 * Delete passenger.
		 *
		 * @param idPassenger the id passenger
		 * @return true, if successful
		 */
		@PostMapping("/deletepassengers/{idPassenger}")
		public boolean deletePassenger(@PathVariable("idPassenger") long idPassenger) {
			Passenger passenger = passengerRepository.findById(idPassenger).orElse(null);
			if (passenger != null) {
				passengerRepository.delete(passenger);
				return true;
			}
			return false;
		}
	
	
}
