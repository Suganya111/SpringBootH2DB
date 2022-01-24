package com.aaludra.spring.jpa.h2.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeOutputView {
	private String id;
	private String effectiveDate;
	private String salary;
	private String empId;
	private String empName;
	private String empCode;
	private String empDesignation;
	private String doj;
	
	

	


}