package com.verizon.tsp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tsp.models.TicketStatus;
import com.verizon.tsp.models.Tickets;
import com.verizon.tsp.models.User;

@Repository
public interface TicketsDao extends JpaRepository<Tickets, Long>{
	
	Tickets findByStatus(TicketStatus status);
	List<Tickets> findByUser(User user);
//	List<Tickets> findByRaisedDate(Date raisedDate);

	public List<Tickets> findByRaisedDate(Date date);
	public List<Tickets> findByResolvedDate(Date date);
	
}
