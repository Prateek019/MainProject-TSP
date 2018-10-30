package com.verizon.tsp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tsp.dao.PlanDetailsDao;
import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.TelecomCircle;

@Service
public class PlanDetailsServiceImpl implements PlanDetailsService{

	@Autowired
	PlanDetailsDao pddao;
	
	@Override
	public List<PlanDetails> getAllPlan() {
		return pddao.findAll();
	}

	@Override
	public PlanDetails findByPlanId(long planId) {
        PlanDetails pd = null;
		
		Optional<PlanDetails> optPD = pddao.findById(planId);
		
		if( optPD.isPresent()) {
			pd = optPD.get();
		}
		return pd;
	}

	@Override
	public PlanDetails createPlan(PlanDetails pd) {
		return pddao.save(pd);
		
	}

	@Override
	public PlanDetails updatePlan(PlanDetails pd) {
		return pddao.save(pd);
	}

	@Override
	public boolean deletePlan(long planId) {
		
		boolean isDeleted=false;
		if(pddao.existsById(planId)) {
			pddao.deleteById(planId);
			isDeleted=true;
		}
		
		return isDeleted;
		
	}

	@Override
	public List<PlanDetails> findByTc(TelecomCircle tc) {
		return pddao.findByTc(tc);
	}

	@Override
	public List<Double> getAllPlanPrice() {
		List<PlanDetails> planList= new ArrayList<PlanDetails>();
		planList= pddao.findAll();
		List<Double> planPrice=new ArrayList<Double>();
		for(PlanDetails plan: planList) {
			planPrice.add(plan.getPlanPrice());
		}
		// TODO Auto-generated method stub
		return planPrice;
	}

}
