package com.thuan.hibernate.model;

public class EmployeeNameAndAge {

	private String firstname;
	private byte age;

	public EmployeeNameAndAge() {
		super();
	}

	public EmployeeNameAndAge(String firstname, byte age) {
		super();
		this.firstname = firstname;
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeNameAndAge [firstname=" + firstname + ", age=" + age + "]";
	}
}
