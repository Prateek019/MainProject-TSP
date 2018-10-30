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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="telecomcircle")
public class TelecomCircle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tcId;
	
	private String state;
	private String district;
	private String city;
	@Enumerated(EnumType.STRING)
	private PrimaryLanguage primaryLang;
	
	/*@OneToOne((mappedBy="tc",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private long tcid;
	*/
	/*@OneToMany(mappedBy="tc",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Plan_TelecomCircle_Mapping> ptm;
	*/
	
	@ManyToMany(mappedBy="tc")
	@JsonBackReference(value="TCAndPD")
	private List<PlanDetails> pd;
	
	@ManyToMany(mappedBy="tc")
	@JsonBackReference(value="UserAndTC")
	private List<User> user;
	
	
	@OneToMany(mappedBy="tc",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//@JsonManagedReference(value="CSAAndTC")
	private List<CSA> csa;
	
	public List<CSA> getCsa() {
		return csa;
	}

	public void setCsa(List<CSA> csa) {
		this.csa = csa;
	}

	public List<PlanDetails> getPd() {
		return pd;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}


	public void setPd(List<PlanDetails> pd) {
		this.pd = pd;
	}

	public TelecomCircle() {

	}

	


	public TelecomCircle(long tcId, String state, String district, String city, PrimaryLanguage primaryLang,
			List<PlanDetails> pd, List<User> user, List<CSA> csa) {
		super();
		this.tcId = tcId;
		this.state = state;
		this.district = district;
		this.city = city;
		this.primaryLang = primaryLang;
		this.pd = pd;
		this.user = user;
		this.csa = csa;
	}

	public long getTcId() {
		return tcId;
	}

	public void setTcId(long tcId) {
		this.tcId = tcId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PrimaryLanguage getPrimaryLang() {
		return primaryLang;
	}

	public void setPrimaryLang(PrimaryLanguage primaryLang) {
		this.primaryLang = primaryLang;
	}

}
