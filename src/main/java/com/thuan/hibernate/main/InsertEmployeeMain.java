package com.thuan.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class InsertEmployeeMain {

	public static void main(String[] args) {

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

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		session.save(emp7);
		session.save(emp8);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

}
