package com.thuan.hibernate.main;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.model.EmpNameAndDeptName;
import com.thuan.hibernate.utils.HibernateUtils;

public class SelectEmployeeMain {

	public static void main(String[] args) {
//		withFrom();
//		withAlias();
		withAliasGroupByName();
//		withParameter();
//		withMax();
//		withAvg();
//		withPaging();
//		withEmpNameAndDeptName();
//		withEmpNameAndDeptNameUsingConstructor();
//		withLeftJoin();
	}

	private static void withFrom() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withAlias() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee AS E";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withAliasGroupByName() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee AS E ORDER BY E.name";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withParameter() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee AS E where E.salary =:salary";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("salary", 1000);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withMax() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "Select Max(E.salary )FROM Employee AS E";
		Query<Integer> query = session.createQuery(hql, Integer.class);
		Integer maxSalary = query.getSingleResult();
		System.out.println("Max salary = " + maxSalary);

		session.close();
	}

	private static void withAvg() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "Select AVG(E.salary )FROM Employee AS E";
		Query<Double> query = session.createQuery(hql, Double.class);
		Double maxSalary = query.getSingleResult();
		System.out.println("Avg salary = " + maxSalary);

		session.close();
	}

	private static void withPaging() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee AS E";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setFirstResult(3);// offset
		query.setMaxResults(3);// limit
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withEmpNameAndDeptName() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT E.name, E.department.name FROM Employee AS E";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> employees = query.list();
		for (Object[] object : employees) {
			System.out.println(object[0] + " " + object[1]);
		}

		session.close();
	}

	private static void withEmpNameAndDeptNameUsingConstructor() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT new com.thuan.hibernate.model.EmpNameAndDeptName(E.name, E.department.name) FROM Employee AS E";
		Query<EmpNameAndDeptName> query = session.createQuery(hql, EmpNameAndDeptName.class);
		List<EmpNameAndDeptName> employees = query.list();
		System.out.println(
				"Method withEmpNameAndDeptNameUsingConstructor(), list size = " + CollectionUtils.size(employees));
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withLeftJoin() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT new com.thuan.hibernate.model.EmpNameAndDeptName(E.name, D.name) FROM Employee E Left join Department D On E.department = D";
		Query<EmpNameAndDeptName> query = session.createQuery(hql, EmpNameAndDeptName.class);
		List<EmpNameAndDeptName> employees = query.list();
		System.out.println("Method withLeftJoin(), list size = " + CollectionUtils.size(employees));
		employees.forEach(System.out::println);

		session.close();
	}
}
