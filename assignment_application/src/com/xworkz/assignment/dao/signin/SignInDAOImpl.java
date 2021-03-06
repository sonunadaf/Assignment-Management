package com.xworkz.assignment.dao.signin;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class SignInDAOImpl implements ISignInDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void updateFailSignIn(AdminEntity adminEntity) throws DAOException {
		Session session = null;
		Transaction transaction = null;
		System.out.println("Failed login : " + adminEntity.getFailLogin());
		try {
			if (adminEntity != null) {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				if (adminEntity.getFailLogin() == null) {
					adminEntity.setFailLogin(1);
					System.out.println("Failed login : " + adminEntity.getFailLogin());
					session.update(adminEntity);
					transaction.commit();
				} else if (adminEntity.getFailLogin() >= 0) {
					Integer failedLoginCount = adminEntity.getFailLogin();
					adminEntity.setFailLogin(failedLoginCount + 1);
					session.update(adminEntity);
					transaction.commit();
				}
			}
		} catch (HibernateException e) {
			transaction.rollback();
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		}
	}

	@Override
	public void updateFailLoginByZero(AdminEntity getAdminFromDb) throws DAOException {
		Session session = null;
		Transaction transaction = null;
		System.out.println("Failed login : " + getAdminFromDb.getFailLogin());
		try {
			if (getAdminFromDb != null) {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				session.update(getAdminFromDb);
				transaction.commit();
			}
		} catch (HibernateException e) {
			transaction.rollback();
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		}

	}
}
