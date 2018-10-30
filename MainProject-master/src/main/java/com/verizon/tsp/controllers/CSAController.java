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
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;
import com.verizon.tsp.services.CSAServiceImpl;
import com.verizon.tsp.services.TCircleService;

@RestController
@RequestMapping("/csa")
//@CrossOrigin
public class CSAController {

	@Autowired
	CSAServiceImpl csaservice;
	
	@Autowired
	TCircleService tcservice;
	
	
	@GetMapping
	public ResponseEntity<List<CSA>> getAllCSA(){
		return new ResponseEntity<>(csaservice.getAllCSA(),HttpStatus.OK);
	}
	
	@GetMapping("/{csaId}")
	public ResponseEntity<CSA> findByCSAId(@PathVariable("csaId") long csaId) {
		
		ResponseEntity<CSA> resp;
		
		CSA csa = csaservice.findByCSAId(csaId);
		
		if (csa == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(csa, HttpStatus.OK);
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<CSA> createCSA(@RequestBody CSA csa) {
		ResponseEntity<CSA> resp = null;
		
		CSA csa_return = csaservice.createCSA(csa);
		
		if(csa_return != null) {
			resp = new ResponseEntity<>(csa_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}
			
	@PutMapping
	public ResponseEntity<CSA> updateCSA(@RequestBody CSA csa) {
		ResponseEntity<CSA> resp = null;
		
		CSA csa_return = csaservice.updateCSA(csa);
		
		if(csa_return != null) {
			System.out.println("CSAAA:" + csa_return);
			resp = new ResponseEntity<>(csa_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}
	
	@DeleteMapping("/{csaId}")
	public ResponseEntity<Void> deleteCSA(@PathVariable("csaId") int csaId) {
		ResponseEntity<Void> resp = null;

		if (csaservice.deleteCSA(csaId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
	
	@GetMapping("/telecom/{tcId}")
	public ResponseEntity<List<CSA>> findTicketByUser(@PathVariable("tcId") long tcId) {
		
		TelecomCircle tc = tcservice.findByTelecomCircleId(tcId);
		
		ResponseEntity<List<CSA>> resp;
		
		List<CSA> csa_return = csaservice.findByTc(tc);
		
		if (csa_return == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(csa_return, HttpStatus.OK);
		
		return resp;
	}
	


}
