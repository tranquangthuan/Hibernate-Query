package com.thuan.hibernate.main;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thuan.hibernate.utils.HibernateUtils;

public class UpdateMain {

	public static void main(String[] args) {
		update(1, "Name by Updated");
	}

	private static void update(int empId, String name) {
		Transaction transaction = null;
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			transaction = session.beginTransaction();

			Query query = session.createQuery("update Employee set name = :name where id = :id");
			query.setParameter("name", name);
			query.setParameter("id", empId);
			int result = query.executeUpdate();
			System.out.println("total record updated = " + result);
			transaction.commit();

			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
