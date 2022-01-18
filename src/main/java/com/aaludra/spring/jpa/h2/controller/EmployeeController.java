package com.aaludra.spring.jpa.h2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaludra.spring.jpa.h2.model.CreateEmployeeRequest;
import com.aaludra.spring.jpa.h2.model.Employee;
import com.aaludra.spring.jpa.h2.model.EmployeeResponse;
import com.aaludra.spring.jpa.h2.model.EmployeeService;
import com.aaludra.spring.jpa.h2.model.UpdateEmployeeRequest;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/getAll")
	public List<Employee> getEmployee() {
		List<Employee> empList = empService.getAll();
		return empList;

	}

	@PostMapping("/create")
	public EmployeeResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest createRequest)
	{
	Employee e=empService.createEmployee(createRequest);
	
	return new EmployeeResponse(e);
		
	}

	@PutMapping("/update")
	public EmployeeResponse updateEmployee(@Valid @RequestBody UpdateEmployeeRequest updateRequest) {
		Employee e = empService.updateEmployee(updateRequest);
		return new EmployeeResponse(e);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable long id) {
		return empService.deleteEmployee(id);

	}

	@GetMapping("get/{id}")
	public List<Employee> getByIdEmployee(@PathVariable long id)
	{
		List<Employee> emp = empService.getByIdEmployee(id);
		return emp;
	}
}
