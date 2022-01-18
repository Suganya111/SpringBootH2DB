package com.aaludra.spring.jpa.h2.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

	private long empId;
	private String empName;
	private String empCode;
	private String empDesignation;
	private float empSalary;
	private Timestamp doj;

	public EmployeeResponse(Employee emp) {
		this.empId = emp.getEmpId();
		this.empName = emp.getEmpName();
		this.empCode = emp.getEmpCode();
		this.empDesignation = emp.getEmpDesignation();
		this.empSalary = emp.getEmpSalary();
		this.doj = emp.getDoj();

	}

}
