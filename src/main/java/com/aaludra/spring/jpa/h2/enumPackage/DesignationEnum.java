package com.aaludra.spring.jpa.h2.enumPackage;

public enum DesignationEnum {
	JavaDeveloper("JavaDeveloper"), TechnicalLead("TechnicalLead"), ProjectManager("ProjectManager");


	String role;

	DesignationEnum(String role) {
		this.role = role;
	}

	public static DesignationEnum check(String designation) {
		for (DesignationEnum values : DesignationEnum.values()) {
			if (values.role.equals(designation))
				return values;
		}
		return null;
	}

}
