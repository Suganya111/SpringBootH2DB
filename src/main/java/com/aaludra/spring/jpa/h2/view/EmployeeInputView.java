package com.aaludra.spring.jpa.h2.view;

import com.aaludra.spring.jpa.h2.model.Employee;
import com.aaludra.spring.jpa.h2.model.EmployeeSalary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInputView {

	private String effectiveDate;
	private String salary;
	private String empName;
	private String empCode;
	private String empDesignation;

	public Employee buildInEmployee(EmployeeInputView inView) {

		Employee employee = new Employee();

		employee.setEmpName(inView.getEmpName());
		employee.setEmpCode(inView.getEmpCode());
		employee.setEmpDesignation(inView.getEmpDesignation());
		// employee.setDoj(DateUtil.convertStringToTimestamp(inView.getEffectiveDate()));

		return employee;
	}

	public EmployeeSalary buildInEmployeeSalary(EmployeeInputView inView) {
		EmployeeSalary eSalary = new EmployeeSalary();
		eSalary.setSalary(Float.parseFloat(inView.getSalary()));
		// eSalary.setEffectiveDate(DateUtil.convertStringToTimestamp(inView.getEffectiveDate()));

		return eSalary;
	}

	public EmployeeOutputView buildOutEmployee(Employee employee) {

		EmployeeOutputView outView = new EmployeeOutputView();
		outView.setId(Long.toString(employee.getEmployeeSalary().getId()));
		outView.setEmpId(Long.toString(employee.getEmpId()));
		outView.setEmpName(employee.getEmpName());
		outView.setEmpCode(employee.getEmpCode());
		outView.setEmpDesignation(employee.getEmpDesignation());
		outView.setSalary(Float.toString(employee.getEmployeeSalary().getSalary()));
		outView.setEffectiveDate(employee.getEmployeeSalary().getEffectiveDate().toString());
		outView.setDoj(employee.getEmployeeSalary().getEffectiveDate().toString());

		return outView;
	}

}
