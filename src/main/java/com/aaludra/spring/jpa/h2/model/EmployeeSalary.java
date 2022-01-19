package com.aaludra.spring.jpa.h2.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_employee_salary")
@Getter
@Setter
public class EmployeeSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "effectiveDate")
	private Timestamp effectiveDate;
	@Column(name = "Salary")
	private float salary;
	@OneToOne
	@JoinColumn(name = "emp_Id")
	private Employee employee;

}
