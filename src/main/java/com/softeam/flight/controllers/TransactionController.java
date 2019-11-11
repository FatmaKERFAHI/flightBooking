package com.softeam.flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeam.flight.entities.Transaction;
import com.softeam.flight.services.TransactionService;

import io.swagger.annotations.Api;


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
}
