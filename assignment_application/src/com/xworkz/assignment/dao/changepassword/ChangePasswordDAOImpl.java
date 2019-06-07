package com.xworkz.assignment.dao.changepassword;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.admin.AdminEntity;

@Repository
public class ChangePasswordDAOImpl implements IChangePasswordDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean changePassword(AdminEntity adminEntity) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(adminEntity);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

}
