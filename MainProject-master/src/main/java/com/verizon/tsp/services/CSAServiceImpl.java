package com.verizon.tsp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tsp.dao.CSADao;
import com.verizon.tsp.models.CSA;
import com.verizon.tsp.models.TelecomCircle;

@Service
public class CSAServiceImpl implements CSAService{
	
	@Autowired
	CSADao csadao;

	@Override
	public List<CSA> getAllCSA() {
		return csadao.findAll();
	}
	
	@Override
	public CSA findByCSAId(long csaId) {
		CSA csa = null;
		
		Optional<CSA> optCSA = csadao.findById(csaId);
		
		if( optCSA.isPresent()) {
			csa = optCSA.get();
		}
		return csa;
	}

	@Override
	public CSA createCSA(CSA csa) {
		 return csadao.save(csa);
	}

	@Override
	public CSA updateCSA(CSA csa) {
		return csadao.save(csa);
	}

	@Override
	public boolean deleteCSA(long csaId) {
		
		boolean isDeleted=false;
		if(csadao.existsById(csaId)) {
			csadao.deleteById(csaId);
			isDeleted=true;
		}
		
		return isDeleted;
		
	}

	@Override
	public List<CSA> findByTc(TelecomCircle tc) {
		return csadao.findByTc(tc);
		}
	
	
}
