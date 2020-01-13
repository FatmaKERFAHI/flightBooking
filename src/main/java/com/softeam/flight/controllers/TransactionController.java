package com.softeam.flight.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softeam.flight.entities.Reservation;
import com.softeam.flight.entities.Transaction;
import com.softeam.flight.services.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping(value = "/transactions")
@Api(description = "Transaction REST Controler", value = "/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
    
	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		List<Transaction> allTransactions =transactionService.getAllTransactions();
        return new ResponseEntity<List<Transaction>>(allTransactions, HttpStatus.OK) ;
	}
	
	@PostMapping(value= "/save")
	@ApiOperation(value = "Save transaction", response = Reservation.class, responseContainer = "ResponseEntity")
	public ResponseEntity<Transaction> createFlight(@RequestBody Transaction transaction) {
		Transaction savedTransaction = transactionService.saveTransaction(transaction);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idTransaction}")
				.buildAndExpand(savedTransaction.getIdTransaction()).toUri();
		return ResponseEntity.created(location).build();
	}
}
