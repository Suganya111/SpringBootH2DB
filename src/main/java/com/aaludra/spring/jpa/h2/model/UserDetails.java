package com.aaludra.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_user_details")
public class UserDetails {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="PhoneNo")
	private String  phoneno;
	@Column(name="Address")
	private String address;
	@Column(name="DOB")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	@Column(name="Gender")
	private String gender;
	
	@OneToOne
	@JoinColumn(name="user_id")

	private User user;

	}

	



