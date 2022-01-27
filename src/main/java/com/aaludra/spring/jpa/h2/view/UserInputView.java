package com.aaludra.spring.jpa.h2.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class UserInputView {
	
	private String username;
	private String email;
	private String password;
	private String status;
	private String logindetails;
	private String phoneno;
	private String address;
	private String dob;
	private String gender;
	
	public UserInputView(String username, String email, String password, String status, String logindetails,
			String phoneno, String address, String dob, String gender) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.logindetails = logindetails;
		this.phoneno = phoneno;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}

	
	
}
