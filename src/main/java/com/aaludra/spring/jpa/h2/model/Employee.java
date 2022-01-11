package com.aaludra.spring.jpa.h2.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
	@Id
	private long empId;
	private String empName;
	private String empCode;
	private String empDesignation;
	private float empSalary;
	private Timestamp doj;

}
