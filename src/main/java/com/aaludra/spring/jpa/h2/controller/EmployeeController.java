package com.aaludra.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaludra.spring.jpa.h2.model.Employee;
import com.aaludra.spring.jpa.h2.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(empRepo.save(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		try {
			List<Employee> list = empRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> get(@PathVariable Long id) {
		Optional<Employee> employee = empRepo.findById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Optional<Employee> employeeData = empRepo.findById(id);

		if (employeeData.isPresent()) {
			Employee emp = employeeData.get();
			emp.setEmpName(employee.getEmpName());
			emp.setEmpCode(employee.getEmpCode());
			emp.setEmpDesignation(employee.getEmpDesignation());
			emp.setDoj(employee.getDoj());
			return new ResponseEntity<>(empRepo.save(emp), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		try {
			empRepo.deleteById(id);
			
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			catch (Exception e)

		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}



}
