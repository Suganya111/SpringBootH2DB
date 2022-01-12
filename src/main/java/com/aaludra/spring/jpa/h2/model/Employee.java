package com.aaludra.spring.jpa.h2.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private long empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_code")
	private String empCode;
	@Column(name = "emp_designation")
	private String empDesignation;
	@Column(name = "emp_salary")
	private float empSalary;
	@Column(name = "doj")
	private Timestamp doj;

	public Employee(CreateEmployeeRequest createRequest) {
		this.empId = createRequest.getEmpId();
		this.empName = createRequest.getEmpName();
		this.empCode = createRequest.getEmpCode();
		this.empDesignation = createRequest.getEmpDesignation();
		this.empSalary = createRequest.getEmpSalary();
		this.doj = createRequest.getDoj();

	}


}
