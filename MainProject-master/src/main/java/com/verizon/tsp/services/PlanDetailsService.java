package com.verizon.tsp.services;

import java.util.List;

import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

public interface PlanDetailsService {

	public List<PlanDetails> getAllPlan();
	public PlanDetails findByPlanId(long planId); //getbyid
	public PlanDetails createPlan(PlanDetails pd);
	public PlanDetails updatePlan(PlanDetails pd);
	public boolean deletePlan(long planId);
	List<PlanDetails> findByTc(TelecomCircle tc);
	public List<Double> getAllPlanPrice();
}
