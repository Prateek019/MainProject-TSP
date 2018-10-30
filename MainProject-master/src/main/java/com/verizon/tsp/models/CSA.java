package com.verizon.tsp.models;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "csa")
public class CSA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long csaId;
	
	@NotEmpty(message="First Name can not be empty")
	private String csaFname;
	
	@NotEmpty(message="Last Name can not be empty")
	private String csaLname;
	
	@NotEmpty(message="Phone Number can not be empty")
	@Pattern(regexp="\\d{10}",message="mobile number can be ony 10 digits")
	private String csaMobileNo;
	
	@NotEmpty(message="Email Id can not be null")
	@Email(message="Invalid Email Id")
	private String csaEmailId;
	
	
	@Enumerated(EnumType.STRING)
	private PrimaryLanguage csaPrimaryLang;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tc")
	@JsonBackReference(value="CSAAndTC")
	private TelecomCircle tc;
	
	public TelecomCircle getTc() {
		return tc;
	}

	public void setTc(TelecomCircle tc) {
		this.tc = tc;
	}

	public CSA() {
		
	}

	public long getCsaId() {
		return csaId;
	}

	public void setCsaId(long csaId) {
		this.csaId = csaId;
	}

	public String getCsaFname() {
		return csaFname;
	}

	public void setCsaFname(String csaFname) {
		this.csaFname = csaFname;
	}

	public String getCsaLname() {
		return csaLname;
	}

	public void setCsaLname(String csaLname) {
		this.csaLname = csaLname;
	}

	public String getCsaMobileNo() {
		return csaMobileNo;
	}

	public void setCsaMobileNo(String csaMobileNo) {
		this.csaMobileNo = csaMobileNo;
	}

	public String getCsaEmailId() {
		return csaEmailId;
	}

	public void setCsaEmailId(String csaEmailId) {
		this.csaEmailId = csaEmailId;
	}

	public PrimaryLanguage getCsaPrimaryLang() {
		return csaPrimaryLang;
	}

	public void setCsaPrimaryLang(PrimaryLanguage csaPrimaryLang) {
		this.csaPrimaryLang = csaPrimaryLang;
	}

	public CSA(long csaId, @NotEmpty(message = "First Name can not be empty") String csaFname,
			@NotEmpty(message = "Last Name can not be empty") String csaLname,
			@NotEmpty(message = "Phone Number can not be empty") @Pattern(regexp = "\\d{10}", message = "mobile number can be ony 10 digits") String csaMobileNo,
			@NotEmpty(message = "Email Id can not be null") @Email(message = "Invalid Email Id") String csaEmailId,
			PrimaryLanguage csaPrimaryLang, TelecomCircle tc) {
		super();
		this.csaId = csaId;
		this.csaFname = csaFname;
		this.csaLname = csaLname;
		this.csaMobileNo = csaMobileNo;
		this.csaEmailId = csaEmailId;
		this.csaPrimaryLang = csaPrimaryLang;
		this.tc = tc;
	}

	
	
	
	

}
