package com.verizon.tsp.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tsp.models.CSA;
import com.verizon.tsp.models.TicketStatus;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;
import com.verizon.tsp.services.TicketsService;
import com.verizon.tsp.services.TicketsServiceImpl;
import com.verizon.tsp.services.UserService;
import com.verizon.tsp.services.UserServiceImpl;

@RestController
@RequestMapping("/tickets")
//@CrossOrigin
public class TicketsController {

	@Autowired
	TicketsService tktservice;
	
	@Autowired
	UserService userservice;
	
	@GetMapping
	public ResponseEntity<List<Tickets>> getAllTicket(){
		return new ResponseEntity<>(tktservice.getAllTicket(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Tickets> createTicket(@RequestBody Tickets tkt) {
		ResponseEntity<Tickets> resp = null;
		
		Tickets tkt_return = tktservice.createTicket(tkt);
		
		if(tkt_return != null) {
			resp = new ResponseEntity<>(tkt_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	@PutMapping
	public ResponseEntity<Tickets> updateTicket(@RequestBody Tickets tkt) {
		ResponseEntity<Tickets> resp = null;
		
		Tickets tkt_return = tktservice.updateTicket(tkt);
		
		if(tkt_return != null) {
			resp = new ResponseEntity<>(tkt_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<Tickets> findByTicketval(@PathVariable("status") TicketStatus status) {
		
		ResponseEntity<Tickets> resp;
		
		Tickets tkt_return = tktservice.findByStatus(status);
		
		if (tkt_return == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(tkt_return, HttpStatus.OK);
		
		return resp;
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Tickets>> findTicketByUser(@PathVariable("userId") long userId) {
		
		User user = userservice.findByUserId(userId);
		
		ResponseEntity<List<Tickets>> resp;
		
		List<Tickets> tkt_return = tktservice.findByUser(user);
		
		if (tkt_return == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(tkt_return, HttpStatus.OK);
		
		return resp;
	}
	
	@GetMapping("/search/raised/{date}")
	public ResponseEntity<List<Tickets>> getTicketbyRaisedDate(@PathVariable("date") String date) throws ParseException{
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date2 = sdf1.parse(date);
		Date sqlStartDate = new java.sql.Date(date2.getTime()); 
		
		ResponseEntity<List<Tickets>> resp = null;
		
		
		List<Tickets> tkt= tktservice.findTicketByRaisedDate(sqlStartDate);
		return new ResponseEntity<>(tkt,HttpStatus.OK);		
		
	}

	@GetMapping("/search/resolved/{date}")
	public ResponseEntity<List<Tickets>> getTicketbyResolvedDate(@PathVariable("date") String date) throws ParseException{
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date2 = sdf1.parse(date);
		Date sqlResolvedDate = new java.sql.Date(date2.getTime()); 
		

		ResponseEntity<List<Tickets>> resp = null;
		
		List<Tickets> tkt= tktservice.findTicketByResolvedDate(sqlResolvedDate);
		return new ResponseEntity<>(tkt,HttpStatus.OK);		
		
	}

	//	@GetMapping("/date/{raisedDate}")
//	public ResponseEntity<List<Tickets>> findUserByActivationDate(@PathVariable("raisedDate") String raisedDate) {
//		
//	
//
//		 Date date1;
//		try {
//			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(raisedDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//		//Date localDate = Date.parse(raisedDate, formatter);
//		
//		ResponseEntity<List<Tickets>> resp;
//		
//		List<Tickets> user = tktservice.findTicketByDate(date1);
//		
//		if (user == null)
//			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		else
//			resp = new ResponseEntity<>(user, HttpStatus.OK);
//		
//		return resp;
//	}
	


}

