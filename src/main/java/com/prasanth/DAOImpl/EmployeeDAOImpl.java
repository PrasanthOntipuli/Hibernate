package com.prasanth.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prasanth.DAO.EmployeeDAO;
import com.prasanth.model.Employee;

@Transactional
@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO 
{
  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Session session;
	public int deleteByID(int id) 
	{
		
		try 
		{
			System.out.println("Session Factory  ::"+sessionFactory);
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		 Transaction tx=session.beginTransaction();
		
		try
		{
	      
	      session.delete(session.get(Employee.class,id));
	      return id;
	      
		}catch(HibernateException he)
		{
			tx.rollback();
			System.out.println("Unable to persist Data \n Rollbacked the Transcation");
			return 0;
		}
		finally{
			tx.commit();
		}
	
	}

	public void addEmployee(Employee emp) {
		
	try
	{
		System.out.println("Session Factory is "+ sessionFactory);
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Employees Deatais"+emp.getAddress());
//		tx.begin();
		session.save(emp);
		tx.commit();
	}
	catch(HibernateException hex)
	{
		System.out.println("execption "+hex);
	}
			System.out.println("Must Persist");
		
		
	}

	public Employee getEmployeeById(int id) 
	{
	Employee emp=new Employee();
	   
	
	try 
	{
	    session = sessionFactory.getCurrentSession();
	} 
	catch (HibernateException e) 
	{
	    session = sessionFactory.openSession();
	}
	Transaction tx=session.beginTransaction();
	try
	{
		emp=(Employee) session.get(Employee.class, id) ;		
	}
	catch(HibernateException hex)
	{
		System.out.println("Cannot get the Employee Object execption is "+hex);
	}
	
	   return emp;
	}

	
	
	public List<Employee> getEmployeesBySalary(int salary) 
	{
		try 
		{
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    session = sessionFactory.openSession();
		}
		Transaction tx=session.beginTransaction();
		try
		{
			String query="Select * from Employee";
			Query q=(Query) session.createQuery(query);
			List<Employee> list=q.list();
			return list;
		}
		catch (HibernateException hex) {
			tx.rollback();
		}
		finally{
			if(!tx.wasCommitted())
			{
				tx.commit();
			}
		}
		
		
		return null;
	}

	public List<Employee> getEmployeesByName(String name) {
	
		return null;
	}

	public List<Employee> getEmployees() 
	{
		Transaction tx;
		List<Employee> list=new ArrayList<Employee>();
		try 
		{
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
			//System.out.println("new session is not been created using old one");
		    session = sessionFactory.openSession();
		}
		tx=session.beginTransaction();
//		System.out.println("is Transcation is null"+tx);
		try
		{
			
			String query="from Employee";
			Query q=session.createQuery(query);
			list=q.list();
			return list;
		}
		catch (HibernateException hex) {
			System.out.println("Transaction Rolled back"+hex);
			tx.rollback();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Another Execption"+e);
		}
	
		return list;
	}

	@Override
	public int updateEmployee(Employee employee) {
		try 
		{
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    session = sessionFactory.openSession();
		}
		Transaction tx=session.beginTransaction();
		try
		{
			System.out.println("This is from DAO"+employee+toString());
			 session.saveOrUpdate(employee);
			 
			 
		}
		catch(HibernateException he)
		{
			tx.rollback();
			System.out.println("Unable to persist Data \n Rollbacked the Transcation");
			return 0;
		}
		finally{
			tx.commit();
		}
			
		return employee.getEmployeeId();
	}

}
