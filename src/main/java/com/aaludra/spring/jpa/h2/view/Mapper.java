package com.aaludra.spring.jpa.h2.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aaludra.spring.jpa.h2.model.Employee;
import com.aaludra.spring.jpa.h2.model.EmployeeSalary;
import com.aaludra.spring.jpa.h2.util.DateUtil;

public class Mapper {
	public Employee buildInEmployee(EmployeeInputView inView) {

		Employee employee = new Employee();

		employee.setEmpName(inView.getEmpName());
		employee.setEmpCode(inView.getEmpCode());
		employee.setEmpDesignation(inView.getEmpDesignation());
		employee.setDoj(DateUtil.convertStringToDate(inView.getEffectiveDate()));

		return employee;
	}

	public EmployeeSalary buildInEmployeeSalary(EmployeeInputView inView) {
		EmployeeSalary eSalary = new EmployeeSalary();
		eSalary.setSalary(Float.parseFloat(inView.getSalary()) / 100);
		eSalary.setEffectiveDate(DateUtil.convertStringToDate(inView.getEffectiveDate()));

		return eSalary;
	}

	public EmployeeOutputView buildOutEmployee(Employee employee) {

		EmployeeOutputView outView = new EmployeeOutputView();
		outView.setId(Long.toString(employee.getEmployeeSalary().getId()));
		outView.setEmpId(Long.toString(employee.getEmpId()));
		outView.setEmpName(employee.getEmpName());
		outView.setEmpCode(employee.getEmpCode());
		outView.setEmpDesignation(employee.getEmpDesignation());

		outView.setSalary(DateUtil.convertFloatToString((employee.getEmployeeSalary().getSalary())));

		Date d = employee.getEmployeeSalary().getEffectiveDate();
		DateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
		String strDate = date.format(d);

		outView.setEffectiveDate(strDate);
		outView.setDoj(strDate);

		return outView;
	}

}
