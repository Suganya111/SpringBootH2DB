package com.aaludra.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Tbl_Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_code")
	private String empCode;
	@Column(name = "emp_designation")
	private String empDesignation;

	@Column(name = "doj")
	private Date doj;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonBackReference
	private EmployeeSalary employeeSalary;



}
