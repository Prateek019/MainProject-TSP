package com.verizon.tsp.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tsp.dao.UserDao;
import com.verizon.tsp.models.Month;
import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.models.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;

	
	//User Service
	@Override
	public User findByUserId(long userId) {
		User user = null;
		
		Optional<User> optUser = userdao.findById(userId);
		
		if( optUser.isPresent()) {
			user = optUser.get();
		}
		return user;
	}

	@Override
	public User findAllByMobileNo(String userMobileNumber) {
		//User user = null;
		
		//Optional<User> optUser = userdao.findAllByMobileNo(userMobileNumber);
		User user = userdao.findByUserMobileNumber(userMobileNumber);
		
		/*
		if( optUser.isPresent()) {
			user = optUser.get();
		}
		*/
		return user;
	}

	
	@Override
	public List<User> getAllUsers() {
		return userdao.findAll();
	}

	@Override
	public User createUser(User user) {
		return userdao.save(user);
		
	}

	@Override
	public boolean deleteUser(long userId) {
		
		boolean isDeleted=false;
		if(userdao.existsById(userId)) {
			userdao.deleteById(userId);
			isDeleted=true;
		}
		
		return isDeleted;

	}

	@Override
	public List<User> findUserByActivationMonth(Month activationMonth) {
		return userdao.findByActivationMonth(activationMonth);
	}

	@Override
	public List<User> findUserByActivationMonthAndPd(Month activationMonth, PlanDetails pd) {
		
		return userdao.findByActivationMonthAndPd(activationMonth, pd);
		
	}



}
