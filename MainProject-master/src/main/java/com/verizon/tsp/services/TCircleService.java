package com.verizon.tsp.services;

import java.util.List;

import com.verizon.tsp.models.TelecomCircle;

public interface TCircleService {

	public List<TelecomCircle> getAllTelecomCircle();
	public TelecomCircle findByTelecomCircleId(long tcId); //getbyid
	public TelecomCircle createTelecomCircle(TelecomCircle tc);
	public TelecomCircle updateTelecomCircle(TelecomCircle tc);
	public boolean deleteTelecomCircle(long tcId);
	public TelecomCircle findTCircleByState(String state);
}
