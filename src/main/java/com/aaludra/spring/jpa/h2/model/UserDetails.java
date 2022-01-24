package com.aaludra.spring.jpa.h2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name="User_id")
	private long userid;
	@Column(name="PhoneNo")
	private String phoneno;
	@Column(name="Address")
	private String address;
	@Column(name="DOB")
	private String dob;
	@Column(name="Gender")
	private String gender;

}
