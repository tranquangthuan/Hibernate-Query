package com.thuan.hibernate.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class CriteriaQueryEmployeeMain {

	public static void main(String[] args) {
//		withCreateCriteria();
//		withCriteriaBuilder();
//		withCriteriaBuilderWithAge();
//		withCriteriaBuilderWithAgeAndSalary();
//		withCriteriaBuilderWithAgeOrSalary();
		withCriteriaBuilderWithOrder();
	}

	private static void withCreateCriteria() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

	private static void withCriteriaBuilder() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);

		Query<Employee> query = session.createQuery(cr);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

	private static void withCriteriaBuilderWithAge() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);
		Predicate age = cb.equal(root.get("age"), 35);
		cr.where(age);

		Query<Employee> query = session.createQuery(cr);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

	private static void withCriteriaBuilderWithAgeAndSalary() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);
		Predicate age = cb.equal(root.get("age"), 30);
		Predicate salary = cb.equal(root.get("salary"), 1000);
		Predicate ageAndSalary = cb.and(age, salary);
		cr.where(ageAndSalary);

		Query<Employee> query = session.createQuery(cr);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

	private static void withCriteriaBuilderWithAgeOrSalary() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);
		Predicate age = cb.equal(root.get("age"), 35);
		Predicate salary = cb.equal(root.get("salary"), 3000);
		Predicate ageAndSalary = cb.or(age, salary);
		cr.where(ageAndSalary);

		Query<Employee> query = session.createQuery(cr);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

	private static void withCriteriaBuilderWithOrder() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);
		Predicate age = cb.equal(root.get("age"), 35);
		Predicate salary = cb.ge(root.get("salary"), 2000);
		Predicate ageAndSalary = cb.or(age, salary);
		cr.where(ageAndSalary);
		cr.orderBy(cb.desc(root.get("salary")));

		Query<Employee> query = session.createQuery(cr);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		factory.close();
		session.close();
	}

}
