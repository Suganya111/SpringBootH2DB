package com.aaludra.spring.jpa.h2.request;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {


	private Timestamp effectiveDate;
	private float salary;
	private String empName;
	private String empCode;
	private String empDesignation;


}
