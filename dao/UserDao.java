package com.ar.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ar.model.User;
import com.ar.util.HibernateUtil;

@Repository
public class UserDao {
	
	public User verifyUser(String userName, String userPassword){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query qry = session.createQuery("from GeneralUser where userName=:userName and userPassword=:userPassword");
		qry.setParameter("userName", userName);
		qry.setParameter("userPassword", userPassword);
		User verifiedUser = (User)qry.list().get(0);
		session.getTransaction().commit();
		session.close();
		
		return verifiedUser;
	}

	public void addUser(User user){
		
		
	}
}
