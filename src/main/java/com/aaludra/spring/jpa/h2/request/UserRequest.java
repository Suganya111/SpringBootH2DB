package com.aaludra.spring.jpa.h2.request;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	private String username;
	private String password;
	private String email;
	private Date logindetails;
	private String status;
	private String phoneno;
	private String address;
	private Date dob;
	private String gender;
	

}
