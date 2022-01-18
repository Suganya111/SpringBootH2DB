package com.aaludra.spring.jpa.h2.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeRequest {
	@NotNull(message = "id is mandatory")
	private long empId;
	private String empName;
	private String empCode;
	private String empDesignation;
	private float empSalary;
	private Timestamp doj;

}
