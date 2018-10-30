package com.verizon.tsp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tsp.dao.TelecomCircleDao;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.User;

@Service
public class TCircleServiceImpl implements TCircleService{

	@Autowired
	TelecomCircleDao tcdao;
	
	@Override
	public List<TelecomCircle> getAllTelecomCircle() {
		return tcdao.findAll();
	}

	@Override
	public TelecomCircle findByTelecomCircleId(long tcId) {
        TelecomCircle tc = null;
		
		Optional<TelecomCircle> optTC = tcdao.findById(tcId);
		
		if( optTC.isPresent()) {
			tc = optTC.get();
		}
		return tc;
	}

	@Override
	public TelecomCircle createTelecomCircle(TelecomCircle tc) {
		return tcdao.save(tc);
		
	}

	@Override
	public TelecomCircle updateTelecomCircle(TelecomCircle tc) {
		return tcdao.save(tc);
	}

	@Override
	public boolean deleteTelecomCircle(long tcId) {
		
		boolean isDeleted=false;
		if(tcdao.existsById(tcId)) {
			tcdao.deleteById(tcId);
			isDeleted=true;
		}
		
		return isDeleted;
		
	}

	@Override
	public TelecomCircle findTCircleByState(String state) {
		return tcdao.findByState(state);	
	}

}
