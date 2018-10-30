package com.verizon.tsp.services;

import java.time.LocalDate;
import java.util.List;

import com.verizon.tsp.models.Month;
import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.User;

public interface UserService {

	//User service
	public List<User> getAllUsers();
	public User findByUserId(long userId); //getbyid
	public User createUser(User user);
	public boolean deleteUser(long userId);
		
	public User findAllByMobileNo(String userMobileNumber);
	public List<User> findUserByActivationMonth(Month activationMonth);
	
	public List<User> findUserByActivationMonthAndPd(Month month, PlanDetails pd);

	


	
	//Address service


	
}
