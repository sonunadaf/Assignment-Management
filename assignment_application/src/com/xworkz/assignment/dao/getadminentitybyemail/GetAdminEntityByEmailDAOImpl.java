package com.xworkz.assignment.dao.getadminentitybyemail;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class GetAdminEntityByEmailDAOImpl implements IGetAdminEntityByEmailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AdminEntity getEntityByEmail(String emailid) throws DAOException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("isEmailExist");
			query.setParameter("email", emailid);
			Object adminEntity = query.uniqueResult();
			System.out.println(adminEntity);
			if (adminEntity != null) {
				return (AdminEntity) adminEntity;
			}
		} catch (HibernateException e) {
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
		return null;
	}

}
