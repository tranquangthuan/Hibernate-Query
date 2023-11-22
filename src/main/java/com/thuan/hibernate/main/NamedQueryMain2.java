package com.thuan.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.utils.HibernateUtils;

public class NamedQueryMain2 {

	public static void main(String[] args) {
		findAllDepartment();
		findDepartmentByName("IT");
	}

	private static void findAllDepartment() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Query<Department> query = session.createNamedQuery("DEPARTMENT_FIND_ALL", Department.class);
		List<Department> Departments = query.getResultList();
		Departments.forEach(System.out::println);

		session.close();
	}

	private static void findDepartmentByName(String departmentName) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Query<Department> query = session.createNamedQuery("DEPARTMENT_FIND_BY_NAME", Department.class);
		query.setParameter("name", departmentName);
		List<Department> Departments = query.getResultList();
		Departments.forEach(System.out::println);

		session.close();
	}

}
