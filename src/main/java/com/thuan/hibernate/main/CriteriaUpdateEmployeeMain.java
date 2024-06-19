package com.thuan.hibernate.main;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.entity.Employee;
import com.thuan.hibernate.utils.HibernateUtils;

public class CriteriaUpdateEmployeeMain {

	public static void main(String[] args) {
		updateEmployeeSalary();
	}

	public static void updateEmployeeSalary() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = null;

		try {
			t = session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaUpdate<Employee> update = cb.createCriteriaUpdate(Employee.class);

			Root<Employee> root = update.from(Employee.class);
			update.set(root.get("salary"), 1112);
			update.where(cb.equal(root.get("id"), 10));

			session.createQuery(update).executeUpdate();
			t.commit();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
