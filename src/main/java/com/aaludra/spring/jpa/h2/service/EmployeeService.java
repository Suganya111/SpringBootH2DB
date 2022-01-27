package com.aaludra.spring.jpa.h2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaludra.spring.jpa.h2.model.Employee;
import com.aaludra.spring.jpa.h2.model.EmployeeSalary;
import com.aaludra.spring.jpa.h2.repository.EmployeeRepository;
import com.aaludra.spring.jpa.h2.view.EmployeeInputView;
import com.aaludra.spring.jpa.h2.view.EmployeeOutputView;
import com.aaludra.spring.jpa.h2.view.Mapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	Mapper map = new Mapper();

	EmployeeInputView inView = new EmployeeInputView();

	public EmployeeOutputView create(EmployeeInputView inView) {

		Employee employee = map.buildInEmployee(inView);

		EmployeeSalary eSalary = map.buildInEmployeeSalary(inView);
		eSalary.setEmployee(employee);
		employee.setEmployeeSalary(eSalary);

		return map.buildOutEmployee(empRepo.save(employee));

	}

	public List<EmployeeOutputView> getAllEmployee() {

		List<Employee> list = empRepo.findAll();
		List<EmployeeOutputView> employeeOut = new ArrayList<>();

		if (list.isEmpty()) {
			return employeeOut;
		}

		for (Employee emp : list) {
			EmployeeOutputView employeeOutput = map.buildOutEmployee(emp);
			employeeOut.add(employeeOutput);

		}
		return employeeOut;

	}

	public Optional<EmployeeOutputView> getEmployeeById(long id) {
		Optional<Employee> emp = empRepo.findById(id);

		EmployeeOutputView outView = map.buildOutEmployee(emp.get());
		return Optional.of(outView);
	}

	public void deleteById(long id) {
		empRepo.deleteById(id);
	}

	public EmployeeOutputView updateEmployee(long id, EmployeeInputView inView) {
		Optional<Employee> employee = empRepo.findById(id);

		if (employee.isPresent()) {
			Employee emp = map.buildInEmployee(inView);
			EmployeeSalary eSalary = map.buildInEmployeeSalary(inView);
			emp.setEmpId(id);
			eSalary.setId(id);
			eSalary.setEmployee(emp);
			emp.setEmployeeSalary(eSalary);
			return map.buildOutEmployee(empRepo.save(emp));

		}
		return null;
	}

}
