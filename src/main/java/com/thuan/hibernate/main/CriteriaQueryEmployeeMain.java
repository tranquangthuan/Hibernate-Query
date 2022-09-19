package com.thuan.hibernate.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.model.EmployeeAndDepartment;
import com.thuan.hibernate.model.EmployeeNameAndAge;
import com.thuan.hibernate.utils.HibernateUtils;

public class CriteriaQueryEmployeeMain {

	public static void main(String[] args) {
		withCreateCriteria();
		withCB();
		withCBAge();
		withCBAgeAndSalary();
		withCBAgeOrSalary();
		withCBOrder();
		withCBPaging(2, 2);
		withCB1Colunm();
		withCBMultiColunm();
		withCBMultiColunmWrapper();
		withCBCountTotalEmp();
		withCBMaxSalary();
		withCBJoinTable();
	}

	private static void withCreateCriteria() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withCB() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);

		Query<Employee> query = session.createQuery(cr);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withCBAge() {
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

		session.close();
	}

	private static void withCBAgeAndSalary() {
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

		session.close();
	}

	private static void withCBAgeOrSalary() {
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

		session.close();
	}

	private static void withCBOrder() {
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

		session.close();
	}

	private static void withCBPaging(int limit, int offset) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root);

		Query<Employee> query = session.createQuery(cr).setFirstResult(offset).setMaxResults(limit);
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withCB1Colunm() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<String> cr = cb.createQuery(String.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(root.get("name"));

		Query<String> query = session.createQuery(cr);
		List<String> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withCBMultiColunm() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> cr = cb.createQuery(Object[].class);
		Root<Employee> root = cr.from(Employee.class);
		cr.multiselect(root.get("name"), root.get("age"));

		Query<Object[]> query = session.createQuery(cr);
		List<Object[]> employees = query.getResultList();
		employees.forEach(e -> {
			for (Object objects : e) {
				System.out.print(objects + " ");
			}
			System.out.println();
		});

		session.close();
	}

	private static void withCBMultiColunmWrapper() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeNameAndAge> cr = cb.createQuery(EmployeeNameAndAge.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(cb.construct(EmployeeNameAndAge.class, root.get("name"), root.get("age")));

		Query<EmployeeNameAndAge> query = session.createQuery(cr);
		List<EmployeeNameAndAge> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

	private static void withCBCountTotalEmp() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(cb.count(root));

		Query<Long> query = session.createQuery(cr);
		Long totalEmp = query.getSingleResult();
		System.out.println("Total Emp = " + totalEmp);

		session.close();
	}

	private static void withCBMaxSalary() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Integer> cr = cb.createQuery(Integer.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(cb.max(root.get("salary")));

		Query<Integer> query = session.createQuery(cr);
		Integer totalEmp = query.getSingleResult();
		System.out.println("Max Salary = " + totalEmp);

		session.close();
	}

	private static void withCBJoinTable() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeAndDepartment> cr = cb.createQuery(EmployeeAndDepartment.class);
		Root<Employee> root = cr.from(Employee.class);
		root.join("department", JoinType.INNER);
		cr.select(cb.construct(EmployeeAndDepartment.class, root.get("name"), root.get("age"), root.get("salary"),
				root.get("role"), root.get("address"), root.get("department").get("name")));

		Query<EmployeeAndDepartment> query = session.createQuery(cr);
		List<EmployeeAndDepartment> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}
}
