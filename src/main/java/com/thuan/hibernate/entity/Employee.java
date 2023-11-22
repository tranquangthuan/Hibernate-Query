package com.thuan.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "emp_name")
	private String name;
	private byte age;
	private int salary;
	private String role;

	private String address;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String name, byte age, int salary, String role, String address, Department department) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.role = role;
		this.address = address;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", role=" + role
				+ ", address=" + address + "]";
	}

}
