package com.verizon.tsp.controllers;

import java.util.ArrayList;
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

import com.verizon.tsp.models.Month;
import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;
import com.verizon.tsp.services.PlanDetailsServiceImpl;
import com.verizon.tsp.services.TCircleService;
import com.verizon.tsp.services.UserService;

@RestController
@RequestMapping("/plan")
//@CrossOrigin
public class PlanDetailsController {

	@Autowired
	PlanDetailsServiceImpl pdservice;
	
	@Autowired
	TCircleService tcservice;
		
	@Autowired
	UserService uservice;
	
	@GetMapping
	public ResponseEntity<List<PlanDetails>> getAllPlan(){
		return new ResponseEntity<>(pdservice.getAllPlan(),HttpStatus.OK);
	}
	
	@GetMapping("/{planId}")
	public ResponseEntity<PlanDetails> findByPlanId(@PathVariable("id") long planId) {
		
		ResponseEntity<PlanDetails> resp;
		
		PlanDetails pd = pdservice.findByPlanId(planId);
		
		if (pd == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(pd, HttpStatus.OK);
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<PlanDetails> createPlan(@RequestBody PlanDetails pd) {
		ResponseEntity<PlanDetails> resp = null;
		
		PlanDetails pd_return = pdservice.createPlan(pd);
		
		if(pd_return != null) {
			resp = new ResponseEntity<>(pd_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	
	@PutMapping
	public ResponseEntity<PlanDetails> updatePlan(@RequestBody PlanDetails pd) {
		ResponseEntity<PlanDetails> resp = null;
		
		PlanDetails pd_return = pdservice.updatePlan(pd);
		
		if(pd_return != null) {
			resp = new ResponseEntity<>(pd_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	
	@DeleteMapping("{planId}")
	public ResponseEntity<Void> deletePlan(@PathVariable("planId") int planId) {
		ResponseEntity<Void> resp = null;

		if (pdservice.deletePlan(planId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}

	@GetMapping("/telecom/{tcId}")
	public ResponseEntity<List<PlanDetails>> findTicketByUser(@PathVariable("tcId") long tcId) {
		
		TelecomCircle tc = tcservice.findByTelecomCircleId(tcId);
		
		ResponseEntity<List<PlanDetails>> resp;
		
		List<PlanDetails> pd_return = pdservice.findByTc(tc);
		
		if (pd_return == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(pd_return, HttpStatus.OK);
		
		return resp;
	}
	/*
	@GetMapping("revenue/{month}/{planId}")
	public ResponseEntity<Double> getRevenue(@PathVariable("month") Month month, @PathVariable("planId") int planId){
		
		Month month;
		
		
		int userCount=0;
		
		PlanDetails pd=pdservice.findByPlanId(planId);
		List<User> lUser = uservice.findUserByActivationMonthAndPd(month, pd) ;
		
		userCount = lUser.size();
		double price = pd.getPlanPrice();
		 
		Double d = new Double(userCount*price);
		ResponseEntity<Double> resp = new ResponseEntity<>(d, HttpStatus.OK);
		return resp;
	}
	*/
	@GetMapping("revenue")
	public ResponseEntity<List<Double>> getRevenue(){
		
		List<PlanDetails> plans= pdservice.getAllPlan();
		ResponseEntity<List<Double>> resp;
		List<Double> revenueList = new ArrayList<Double>();
		
		for (PlanDetails pl:plans) {
			for (Month month: Month.values()) {
				long planId=pl.getPlanId();
				int userCount=0;
				
				PlanDetails pd=pdservice.findByPlanId(planId);
				List<User> lUser = uservice.findUserByActivationMonthAndPd(month , pd) ;
				
				userCount = lUser.size();
				double price = pd.getPlanPrice();
				 
				Double d = new Double(userCount*price);
				revenueList.add(d);
			}
			
		}
		resp = new ResponseEntity<>(revenueList, HttpStatus.OK);
		return resp;
	}
}
