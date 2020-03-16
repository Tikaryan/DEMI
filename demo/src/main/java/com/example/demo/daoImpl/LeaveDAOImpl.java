package com.example.demo.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.LeaveDAO;
import com.example.demo.pojo.UserDO;

@Repository
public class LeaveDAOImpl implements LeaveDAO {

	
	 SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(UserDO userDO) {
		currentSession().saveOrUpdate(userDO);
		
	}

}
