package com.verizon.tsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tsp.models.CSA;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.User;
import com.verizon.tsp.services.TCircleServiceImpl;

@RestController
@RequestMapping("/telecom")
//@CrossOrigin
public class TCircleController {

	@Autowired
	TCircleServiceImpl tcservice;
	
	@GetMapping
	public ResponseEntity<List<TelecomCircle>> getAllTelecomCircle(){
		return new ResponseEntity<>(tcservice.getAllTelecomCircle(),HttpStatus.OK);
	}
	
	@GetMapping("/{tcId}")
	public ResponseEntity<TelecomCircle> findByTelecomCircleId(@PathVariable("id") long tcId) {
		
		ResponseEntity<TelecomCircle> resp;
		
		TelecomCircle tc = tcservice.findByTelecomCircleId(tcId);
		
		if (tc == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(tc, HttpStatus.OK);
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<TelecomCircle> createTelecomCircle(@RequestBody TelecomCircle tc) {
		ResponseEntity<TelecomCircle> resp = null;
		
		TelecomCircle tc_return = tcservice.createTelecomCircle(tc);
		
		if(tc_return != null) {
			resp = new ResponseEntity<>(tc_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	@PutMapping
	public ResponseEntity<TelecomCircle> updateTelecomCircle(@RequestBody TelecomCircle tc) {
		ResponseEntity<TelecomCircle> resp = null;
		
		TelecomCircle tc_return = tcservice.updateTelecomCircle(tc);
		
		if(tc_return != null) {
			resp = new ResponseEntity<>(tc_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	
	@DeleteMapping("/{tcId}")
	public ResponseEntity<Void> deleteTelecomCircle(@PathVariable("tcId") int tcId) {
		ResponseEntity<Void> resp = null;

		if (tcservice.deleteTelecomCircle(tcId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}

	@GetMapping("/state/{state}")
	public ResponseEntity<TelecomCircle> findByState(@PathVariable("state") String state) {
		
		ResponseEntity<TelecomCircle> resp;
		
		TelecomCircle tc = tcservice.findTCircleByState(state);
		
		if (tc == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(tc, HttpStatus.OK);
		
		return resp;
	}
	

}
