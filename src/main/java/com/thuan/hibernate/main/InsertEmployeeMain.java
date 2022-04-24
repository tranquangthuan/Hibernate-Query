package com.thuan.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class InsertEmployeeMain {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Employee emp1 = new Employee("Thuan", (byte) 35, 1000, "Dev", "VN");
		Employee emp2 = new Employee("Anh", (byte) 20, 2000, "Dev", "VN");
		Employee emp3 = new Employee("Le", (byte) 25, 3000, "Dev", "VN");
		Employee emp4 = new Employee("Bob", (byte) 30, 1000, "Test", "USA");
		Employee emp5 = new Employee("Alice", (byte) 32, 2000, "Test", "USA");
		Employee emp6 = new Employee("Steven", (byte) 35, 1000, "Test", "USA");

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

}
