package com.thuan.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class SelectEmployeeMain {

	public static void main(String[] args) {
		withFrom();
		withAlias();
		withParameter();
		withMax();
		withAvg();
	}

	private static void withFrom() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

	private static void withAlias() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee AS E";
		Query<Employee> query = session.createQuery(hql, Employee.class);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
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

		factory.close();
		session.close();
	}

	private static void withMax() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "Select Max(E.salary )FROM Employee AS E";
		Query<Integer> query = session.createQuery(hql, Integer.class);
		Integer maxSalary = query.getSingleResult();
		System.out.println("Max salary = " + maxSalary);

		factory.close();
		session.close();
	}

	private static void withAvg() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "Select AVG(E.salary )FROM Employee AS E";
		Query<Double> query = session.createQuery(hql, Double.class);
		Double maxSalary = query.getSingleResult();
		System.out.println("Avg salary = " + maxSalary);

		factory.close();
		session.close();
	}
}
