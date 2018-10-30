package com.verizon.tsp.services;

import java.util.List;

import com.verizon.tsp.models.CSA;
import com.verizon.tsp.models.TelecomCircle;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

public interface CSAService {
	
	public List<CSA> getAllCSA();
	public CSA findByCSAId(long csaId); //getbyid
	public CSA createCSA(CSA csa);
	public CSA updateCSA(CSA csa);
	public boolean deleteCSA(long csaId);
	public List<CSA> findByTc(TelecomCircle tc);


}
