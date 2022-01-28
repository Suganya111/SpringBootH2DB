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

import com.aaludra.spring.jpa.h2.exception.ValidationException;
import com.aaludra.spring.jpa.h2.service.EmployeeService;
import com.aaludra.spring.jpa.h2.validation.EmployeeValidation;
import com.aaludra.spring.jpa.h2.validation.ErrorMessages;
import com.aaludra.spring.jpa.h2.view.EmployeeInputView;
import com.aaludra.spring.jpa.h2.view.EmployeeOutputView;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;


	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeInputView inView) {
		try {
			EmployeeValidation eValidate = new EmployeeValidation();
			eValidate.validate(inView);
			EmployeeOutputView outView = empService.create(inView);
			return new ResponseEntity<>(outView, HttpStatus.CREATED);
		} catch (ValidationException ve) {
			return new ResponseEntity<>(new ErrorMessages(HttpStatus.BAD_REQUEST.value(), ve.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeOutputView>> getAllEmployee() {
		try {
			List<EmployeeOutputView> employeeOut = empService.getAllEmployee();
			if (employeeOut.isEmpty()) {
				return new ResponseEntity<>(employeeOut, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employeeOut, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeOutputView> get(@PathVariable Long id) {
		Optional<EmployeeOutputView> outView = empService.getEmployeeById(id);
		if (outView.isPresent()) {
			return new ResponseEntity<>(outView.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeOutputView> updateEmployee(@PathVariable("id") long id,
			@RequestBody EmployeeInputView inView) {
		try {
			EmployeeOutputView outView = empService.updateEmployee(id, inView);

			return new ResponseEntity<>(outView, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		try {
			empService.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);
		}

		catch (Exception e)

		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
