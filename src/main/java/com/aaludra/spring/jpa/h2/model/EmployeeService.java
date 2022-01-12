package com.aaludra.spring.jpa.h2.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaludra.spring.jpa.h2.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRep;


	public List<Employee> getAll() {

		return empRep.findAll();

	}

	public Employee createEmployee(CreateEmployeeRequest createRequest) {

		Employee emp = new Employee(createRequest);
		return empRep.save(emp);
	}

	public Employee updateEmployee(UpdateEmployeeRequest updateRequest) {
		
		Employee emp=empRep.findById(updateRequest.getEmpId()).get();
		if (updateRequest.getEmpName() != null && !updateRequest.getEmpName().isEmpty())
		{
			updateRequest.setEmpName(updateRequest.getEmpName());

		}
		emp = empRep.save(emp);

		return emp;
	}

}
