package com.verizon.tsp.models;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tickets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tickets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	
	
	
	@OneToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
    private User user;
	
	@Enumerated(EnumType.STRING)
	private TicketType ticketType;
	 private String content;
	 @Enumerated(EnumType.STRING)
	 private TicketStatus status;
	 
	 private Date raisedDate;
	 private Date resolvedDate;
	 
	 
	
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TicketStatus getStatus() {
		return this.status;
	}
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	
	
	
	public Tickets(long ticketId, User user, TicketType ticketType, String content, TicketStatus status,
			Date raisedDate, Date resolvedDate) {
		super();
		this.ticketId = ticketId;
		this.user = user;
		this.ticketType = ticketType;
		this.content = content;
		this.status = status;
		this.raisedDate = raisedDate;
		this.resolvedDate = resolvedDate;
	}
	public Date getRaisedDate() {
		return raisedDate;
	}
	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}
	public Date getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	

