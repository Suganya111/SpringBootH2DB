package com.aaludra.spring.jpa.h2.model;
//import java.security.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.aaludra.spring.jpa.h2.responce.UserResponce;

//import com.aaludra.spring.jpa.h2.request.UserRequest;

import lombok.Getter;

//import com.aaludra.spring.jpa.h2.request.UserRequest;

import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="tbl_user")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="LastLogindetails")
	@CreationTimestamp
	private Date logindetails;
	
	@Column(name="Status")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL,  mappedBy="user")
	@JsonBackReference
	 private UserDetails userDetails;

	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", logindetails=" + logindetails + ", status=" + status + "]";
	}


	

	

	

	
	
	
	

}
