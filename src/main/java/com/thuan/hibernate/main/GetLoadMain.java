package com.thuan.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.thuan.hibernate.entity.Department;
import com.thuan.hibernate.utils.HibernateUtils;

public class GetLoadMain {

	public static void main(String[] args) {
		getById(1);
		loadById(1);
	}

	private static void getById(long deptId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		System.out.println("- Before called ");
		Department dept = session.get(Department.class, deptId);
		System.out.println("- After called ");
		System.out.println(dept);

		session.close();
	}

	private static void loadById(long deptId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		System.out.println("- Before called ");
		Department dept = session.load(Department.class, deptId);
		System.out.println("- After called ");
		System.out.println(dept);

		session.close();
	}

}
