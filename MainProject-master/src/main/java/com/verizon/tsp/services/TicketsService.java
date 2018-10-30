package com.verizon.tsp.services;


import java.util.Date;
import java.util.List;

import com.verizon.tsp.models.TicketStatus;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

public interface TicketsService {

	public List<Tickets> getAllTicket();
	public Tickets createTicket(Tickets tkt);
	public Tickets updateTicket(Tickets tkt);
	public Tickets findByStatus(TicketStatus status);
	public List<Tickets> findByUser(User user);
	//public List<Tickets> findTicketByDate(Date raisedDate);
	
	public List<Tickets> findTicketByRaisedDate(Date date);
	public List<Tickets> findTicketByResolvedDate(Date date);

}
