package com.verizon.tsp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="plandetails")
public class PlanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long planId;
	
	private String planName;
	private double planPrice;
	@Enumerated(EnumType.STRING)
	private Plan planType;
	private String planValidity;
	
	/*@OneToMany(mappedBy="pd",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Plan_TelecomCircle_Mapping> ptm;
	
	@OneToMany(mappedBy="tc",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<TelecomCircle> tc;
	*/
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "plan_tc_mapping")//, joinColumns = @JoinColumn(name = "plan_id", referencedColumnName = "plan_id"), inverseJoinColumns = @JoinColumn(name = "tcId", referencedColumnName = "tcId"))
	 //@JsonManagedReference(value="TCAndPD")
	 private List<TelecomCircle> tc;
	 
	 @ManyToMany(mappedBy="pd")
	 @JsonBackReference(value="UserAndPD")
	 private List<User> user;
	 
		public PlanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

		public long getPlanId() {
			return planId;
		}

		public void setPlanId(long planId) {
			this.planId = planId;
		}

		public String getPlanName() {
			return planName;
		}

		public void setPlanName(String planName) {
			this.planName = planName;
		}

		public double getPlanPrice() {
			return planPrice;
		}

		public void setPlanPrice(double planPrice) {
			this.planPrice = planPrice;
		}

		public Plan getPlanType() {
			return planType;
		}

		public void setPlanType(Plan planType) {
			this.planType = planType;
		}

		public String getPlanValidity() {
			return planValidity;
		}

		public void setPlanValidity(String planValidity) {
			this.planValidity = planValidity;
		}

		public List<TelecomCircle> getTc() {
			return tc;
		}

		public void setTc(List<TelecomCircle> tc) {
			this.tc = tc;
		}

		public List<User> getUser() {
			return user;
		}

		public void setUser(List<User> user) {
			this.user = user;
		}

		public PlanDetails(long planId, String planName, double planPrice, Plan planType, String planValidity,
				List<TelecomCircle> tc, List<User> user) {
			super();
			this.planId = planId;
			this.planName = planName;
			this.planPrice = planPrice;
			this.planType = planType;
			this.planValidity = planValidity;
			this.tc = tc;
			this.user = user;
		}
		
	
	
	
	
}
