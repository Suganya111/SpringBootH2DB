package com.aaludra.spring.jpa.h2.model;
import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
	private long id;
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	@Column(name="Email")
	private String email;
	@CreationTimestamp
	@Column(name="LastLogindetails")
	private Date logindetails;
	@Column(name="Status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="User_id")
	private UserDetails userdetails;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", logindetails=" + logindetails + ", status=" + status + "]";
	}	


}
