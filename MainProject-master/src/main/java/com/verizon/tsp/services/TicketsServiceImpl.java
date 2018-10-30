package com.verizon.tsp.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tsp.dao.TicketsDao;
import com.verizon.tsp.models.TicketStatus;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

@Service
public class TicketsServiceImpl implements TicketsService{

	@Autowired
	TicketsDao tktdao;
	
	@Override
	public List<Tickets> getAllTicket() {
		return tktdao.findAll();
	}

	@Override
	public Tickets createTicket(Tickets tkt) {
		return tktdao.save(tkt);
		
	}

	@Override
	public Tickets updateTicket(Tickets tkt) {
		return tktdao.save(tkt);
	}

	@Override
	public Tickets findByStatus(TicketStatus status) {
		
		Tickets ticket = tktdao.findByStatus(status);
		return ticket;
	}

	@Override
	public List<Tickets> findByUser(User user) {
		return tktdao.findByUser(user);
		
	}

	@Override
	public List<Tickets> findTicketByRaisedDate(Date date) {
		// TODO Auto-generated method stub
		return tktdao.findByRaisedDate( date);
	}

	@Override
	public List<Tickets> findTicketByResolvedDate(Date date) {
		// 
		return tktdao.findByResolvedDate(date);
	}

//	@Override
//	public List<Tickets> findTicketByDate(Date raisedDate) {
//		return tktdao.findByRaisedDate(raisedDate);
//	}

}
