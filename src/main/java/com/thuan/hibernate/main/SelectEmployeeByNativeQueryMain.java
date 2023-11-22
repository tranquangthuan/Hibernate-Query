package com.thuan.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class SelectEmployeeByNativeQueryMain {

	public static void main(String[] args) {
		selectNativeByEmp_Name();
	}

	private static void selectNativeByEmp_Name() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String nativeSQL = "SELECT * FROM Employee Where emp_name=:name ORDER BY emp_name";
		Query<Employee> query = session.createNativeQuery(nativeSQL, Employee.class);
//		String hql = "SELECT E FROM Employee E Where name=:name ORDER BY name";
//		Query<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("name", "Thuan");
		List<Employee> employees = query.getResultList();
		employees.forEach(System.out::println);

		session.close();
	}

}
