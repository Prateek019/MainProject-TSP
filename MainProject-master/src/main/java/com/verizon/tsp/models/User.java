package com.verizon.tsp.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.tomcat.jni.Local;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	
	private String userFname;
	private String userLname;

	@NotEmpty(message = "adharId can not be empty")
	@Size(max = 12, message = "aadharId must be of 12 chars")
	private String userAdharId;

	
	@NotEmpty(message = "Email Id can not be null")
	@Email(message = "Invalid Email Id")
	private String userEmailId;

	@NotEmpty(message="Mobile Number can not be null")
	@Pattern(regexp = "\\d{10}", message = "Mobile Number can be ony 10 digits")
	private String userMobileNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private PrimaryLanguage userPrimaryLang;
	
	// @OneToOne(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		// //two-way mapping to check retrieval

		/*@OneToMany(mappedBy = "services", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JsonManagedReference
		*/
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "user_tc_mapping")//, joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
	 //@JsonManagedReference(value="UserAndTC")
	 private List<TelecomCircle> tc;
	 
	 @OneToMany( mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	 private List<Tickets> tickets;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "user_plan_mapping")//, joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
	 //@JsonManagedReference(value="UserAndPD")
	 private List<PlanDetails> pd;
	 
	/* @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="addressId")
	 
	 private Address address;
*/
	 //private LocalDate activationDate;
	 
	 @Enumerated(EnumType.STRING)
	 private Month activationMonth;
	 





	public Month getActivationMonth() {
		return activationMonth;
	}


	public void setActivationMonth(Month activationMonth) {
		this.activationMonth = activationMonth;
	}





	public User(long userId, String userFname, String userLname,
			@NotEmpty(message = "adharId can not be empty") @Size(max = 12, message = "aadharId must be of 12 chars") String userAdharId,
			@NotEmpty(message = "Email Id can not be null") @Email(message = "Invalid Email Id") String userEmailId,
			@NotEmpty(message = "Mobile Number can not be null") @Pattern(regexp = "\\d{10}", message = "Mobile Number can be ony 10 digits") String userMobileNumber,
			Gender gender, PrimaryLanguage userPrimaryLang, List<TelecomCircle> tc, List<Tickets> tickets,
			List<PlanDetails> pd, Month activationMonth) {
		super();
		this.userId = userId;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userAdharId = userAdharId;
		this.userEmailId = userEmailId;
		this.userMobileNumber = userMobileNumber;
		this.gender = gender;
		this.userPrimaryLang = userPrimaryLang;
		this.tc = tc;
		this.tickets = tickets;
		this.pd = pd;
		this.activationMonth = activationMonth;
	}


	public List<Tickets> getTickets() {
		return tickets;
	}


	public void setTickets(List<Tickets> tickets) {
		this.tickets = tickets;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUserFname() {
		return userFname;
	}


	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}


	public String getUserLname() {
		return userLname;
	}


	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}


	public String getUserAdharId() {
		return userAdharId;
	}


	public void setUserAdharId(String userAdharId) {
		this.userAdharId = userAdharId;
	}


	public String getUserEmailId() {
		return userEmailId;
	}


	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}


	public String getUserMobileNumber() {
		return userMobileNumber;
	}


	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public PrimaryLanguage getUserPrimaryLang() {
		return userPrimaryLang;
	}


	public void setUserPrimaryLang(PrimaryLanguage userPrimaryLang) {
		this.userPrimaryLang = userPrimaryLang;
	}


	public List<TelecomCircle> getTc() {
		return tc;
	}


	public void setTc(List<TelecomCircle> tc) {
		this.tc = tc;
	}


	public List<PlanDetails> getPd() {
		return pd;
	}


	public void setPd(List<PlanDetails> pd) {
		this.pd = pd;
	}


	


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

	
	
	

}
