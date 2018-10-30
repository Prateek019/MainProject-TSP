package com.verizon.tsp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

@Repository
public interface PlanDetailsDao extends JpaRepository<PlanDetails, Long>{

	List<PlanDetails> findByTc(TelecomCircle tc);

}
