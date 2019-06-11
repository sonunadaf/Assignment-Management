package com.xworkz.assignment.dao.member;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.member.MemberEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class GetMemberByEmail {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(GetMemberByEmail.class);

	public MemberEntity getMemberEntity(String email) throws DAOException {

		Session session = null;
		MemberEntity memberEntity = null;
		try {
			String hql = "select memb from MemberEntity memb where memb.email=:em";
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("em", email);
			memberEntity = (MemberEntity) query.uniqueResult();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DAOException(e.getMessage());
		}
		return memberEntity;
	}

}
