package com.verizon.tsp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tsp.models.Month;
import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

	User findByUserMobileNumber(String userMobileNumber);
	//List<User> findByActivationDate(LocalDate activationDate);
	List<User> findByActivationMonth(Month activationMonth);
	List<User> findByActivationMonthAndPd(Month activationMonth, PlanDetails pd);
}
