package com.thuan.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "DEPARTMENT_FIND_ALL", query = "FROM Department D"),
	@NamedQuery(name = "DEPARTMENT_FIND_BY_NAME", query = "FROM Department D where D.name =:name") 
	})
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
