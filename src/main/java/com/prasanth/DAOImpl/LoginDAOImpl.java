package com.prasanth.DAOImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prasanth.DAO.LoginDAO;
import com.prasanth.model.Login;
@Transactional
@Repository("loginDAO")
public class LoginDAOImpl extends AbstractDAO  implements LoginDAO {


	private static final long serialVersionUID = 1L;
	private Session session;
	@Override
	public void saveLogin(Login login) {
		
		Transaction tx=null;
		try 
		{
			System.out.println("Session factory    ::"  +sessionFactory);
			 session = sessionFactory.openSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
			System.out.println("execption cought"+e);
		   
		}
		try {
		    // create session
		    tx = session.beginTransaction();
		    // do something
		    session.save(login);
		    tx.commit();
		} catch (Exception exp)
		{
			System.out.println("Execption is "+exp);
		    tx.rollback();
		}
		  	
		
	}

	@Override
	public void chaingePassword(String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sharePasswordChaingingUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
