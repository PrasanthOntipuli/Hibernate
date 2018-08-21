package com.prasanth.criteriaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prasanth.model.Employee;
import com.prasanth.model.Resource;

public class CriteriaTest {

	public List<Employee> testCriteria(Session s)
	{
		
	Criteria cr=	s.createCriteria(Employee.class);
	cr.add(Restrictions.like("name", "%p%"));
	return 	cr.list();
	}
	public Employee getEmployeeById(Session s)
	{
		Criteria c=s.createCriteria(Employee.class);
		c.add(Restrictions.eq("employeeId",37));
		return (Employee) c.uniqueResult();
	}
	public Employee addResourses(Session s,List<Resource> resources)
	{
		Criteria c=s.createCriteria(Employee.class);
		Employee e=(Employee) c.add(Restrictions.eq("employeeId", 19)).uniqueResult();
		
		e.setresourses(resources);
		return e;
	}
	
	public void persistObjects(Object o,Session s)
	{
		Transaction tx=s.beginTransaction();
	    s.saveOrUpdate(o);
		tx.commit();
		
	}
	public List<Employee> getEmployeeLessSalary(int salary,Session s)
	{
		Criteria c=s.createCriteria(Employee.class);
		c.add(Restrictions.gt("salary", salary));
		return c.list();
	}
	public static void main(String[] args) {

		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Random rn=new Random();
		
		Session s=ctx.getBean(SessionFactory.class).openSession();
		
		CriteriaTest ct=new CriteriaTest();
	    List<Employee>	es=ct.testCriteria(s);
	     
	     for (Employee employee : es) 
	      {
	
		    System.out.println(employee.getName()+"Name"+" and Salary is "+employee.getSalary());
	      }
     	System.out.println("employee details"+ct.getEmployeeById(s));
     	List<Resource> list=new ArrayList<Resource>();
     	list.add((Resource) s.get(Resource.class, rn.nextInt(14)+1));
     	list.add((Resource) s.get(Resource.class, rn.nextInt(14)+1));
     	list.add((Resource) s.get(Resource.class, rn.nextInt(14)+1));
     	list.add((Resource) s.get(Resource.class, rn.nextInt(14)+1));
     	System.out.println("enter id");
     	ct.persistObjects(ct.addResourses(s, list),s);
     	
     	
     	// getting the data from database using criteria object and Expression object 
     	List<Employee> lsits=ct.getEmployeeLessSalary(100, s);
     	for (Employee employee : lsits) {
			System.out.println(employee);
		}
		System.exit(0);
	}

}
