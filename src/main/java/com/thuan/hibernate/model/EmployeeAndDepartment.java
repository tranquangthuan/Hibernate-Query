package com.thuan.hibernate.model;

public class EmployeeAndDepartment {

	private String name;
	private byte age;
	private int salary;
	private String role;
	private String address;
	private String departmentName;

	public EmployeeAndDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeAndDepartment(String name, byte age, int salary, String role, String address,
			String departmentName) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.role = role;
		this.address = address;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "EmployeeAndDepartment [name=" + name + ", age=" + age + ", salary=" + salary + ", role=" + role
				+ ", address=" + address + ", departmentName=" + departmentName + "]";
	}

}
