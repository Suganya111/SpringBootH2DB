package com.aaludra.spring.jpa.h2.validation;

import com.aaludra.spring.jpa.h2.enumPackage.DesignationEnum;
import com.aaludra.spring.jpa.h2.exception.ValidationException;
import com.aaludra.spring.jpa.h2.view.EmployeeInputView;

public class EmployeeValidation {

	public void validate(EmployeeInputView inView) throws ValidationException {
		
		if (inView.getEmpName() == null) {

			throw new ValidationException("Employee Name is mandatory");
		}
		if (inView.getEmpCode() == null)
		{
			throw new ValidationException("Employee code is mandatory");
		}
		if (inView.getSalary() == null) {
			throw new ValidationException("Salary is mandatory");
		}
		if (inView.getEmpDesignation() == null) {
			throw new ValidationException("Designation is mandatory");
		}

		if (inView.getEffectiveDate() == null) {
			throw new ValidationException("Effective date is mandatory");
		}
		if (inView.getEmpName().length() < 3 | inView.getEmpName().length() > 256) {
			throw new ValidationException("Invalid Employee Name");
		}
		if (inView.getEmpCode().length() != 6) {
			throw new ValidationException("Invalid employee code");
		}
		if (inView.getSalary().length() < 4 | inView.getSalary().length() > 7) {
			throw new ValidationException("Invalid salary");
		}


		DesignationEnum de = DesignationEnum.check(inView.getEmpDesignation());
		if (de == null) {
			throw new ValidationException("Invalid Designation");
		}
		

	}
}
