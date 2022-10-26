package com.thuan.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class InsertEmployeeMain {

	public static void main(String[] args) {

		insertData();
		selectAndUpdateEmp(10);
	}

	private static void insertData() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Department department1 = new Department("IT");
		Department department2 = new Department("HR");

		Employee emp1 = new Employee("Thuan", (byte) 35, 1000, "Dev", "VN", department1);
		Employee emp2 = new Employee("Anh", (byte) 20, 2000, "Dev", "VN", department1);
		Employee emp3 = new Employee("Le", (byte) 25, 3000, "Dev", "VN", department1);
		Employee emp4 = new Employee("Bob", (byte) 30, 1000, "Test", "USA", department1);
		Employee emp5 = new Employee("Alice", (byte) 32, 2000, "Test", "USA", department1);
		Employee emp6 = new Employee("Steven", (byte) 35, 1000, "Test", "USA", department1);
		Employee emp7 = new Employee("Miss Thuy", (byte) 35, 1000, "HR", "VN", department2);
		Employee emp8 = new Employee("Ms Van Anh", (byte) 35, 1000, "HR", "USA", department2);
		Employee emp9 = new Employee("Ms Unknown Dept From VN", (byte) 35, 1000, "HR", "VN", null);
		Employee emp10 = new Employee("MR Unknown Dept From USA", (byte) 35, 1000, "HR", "USA", null);

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		session.save(emp7);
		session.save(emp8);
		session.save(emp9);
		session.save(emp10);
		t.commit();
		System.out.println("successfully saved");
		session.close();
	}

	public static void selectAndUpdateEmp(int employeeId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		System.out.println("Find Employee Information");
		Employee em = session.find(Employee.class, employeeId);
		System.out.println(em);
		System.out.println("Update Employee");
		em.setName("MR Unknown BBBB");
		session.save(em);

		t.commit();
		session.close();
	}
}
