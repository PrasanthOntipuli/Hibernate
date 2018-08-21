package com.prasanth.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prasanth.DAO.EmployeeDAO;
import com.prasanth.DAO.LoginDAO;
import com.prasanth.DAOImpl.EmployeeDAOImpl;
import com.prasanth.DAOImpl.LoginDAOImpl;
import com.prasanth.model.Address;
import com.prasanth.model.Employee;
import com.prasanth.model.Login;
import com.prasanth.model.Resource;
import com.prasanth.service.EmployeeService;
import com.prasanth.service.EmployeeServiceImpl;



public class EmployeeElectronicRelation 
{
	
	static List<Resource> res=new ArrayList<Resource>();

	static
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Performed Beans intilization");
		SessionFactory sf=ctx.getBean(SessionFactory.class);
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		 res=sess.createQuery("from Resource").list();
		 tx.commit();
		 try
		 {
			 sess.close();
		 }
		 catch(HibernateException hex)
		 {
			 System.out.println("Unable to close The Session"+hex);
		 }
	}
	static Scanner s=new Scanner(System.in);
	Employee addData()
	{
		Random ran=new Random();
		Employee e=new Employee();
		System.out.println("Enter employee Name");
		e.setName(s.next());
		System.out.println();
		System.out.println("Enter the Salary");
		e.setSalary(s.nextInt());
		List<Resource> resources=new ArrayList<Resource>();
 		for(int i=0;i<3;i++)
		{
		 resources.add( res.get(ran.nextInt(5)+0));
		}
 		e.setresourses(resources);
 		//System.out.println(e.getresourses());
 		  Login l=new Login();
 	        l.setEmployee(e);
 	        System.out.println("enter Password");
 	        l.setPassword(s.next());
 	        System.out.println();
 	        e.setLogin(l);
 	        Address addr=new Address();
 	        System.out.println("enter Address door number");
 	        addr.setDoorNumber(s.nextInt());
 	        System.out.println("Enter address Street");
 	        addr.setStreet(s.next());
 		    e.setAddress(addr);
		return e; 
	}
   
	public static void main(String[] args) {
	
		System.out.println("Started Test");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("It started the data bean obect");
        EmployeeServiceImpl employeeService=ctx.getBean(EmployeeServiceImpl.class);
	    System.out.println("is it here");
	    EmployeeDAO employeeDAO=new EmployeeDAOImpl();
	    Employee employee=new Employee("pramodh", 6567);
	    employee.setAddress(new Address(100, "Ravanagar"));
	    employeeDAO.addEmployee(employee);
	    LoginDAO loginDAO=new LoginDAOImpl();
	    loginDAO.saveLogin(new Login(69, "Terminal"));
	    
	    
//	    List<Employee> obj=employeeService.getEmployees();
//	    
//	    Iterator<Employee> itr=obj.iterator();
//	    while(itr.hasNext())
//	    {
//	    	Employee e=itr.next();
//	    	System.out.println(e.getName()+": Salary is :"+e.getSalary()+"\n");
//	    }
//	    System.out.println("Is data present in the DB is error"+employeeService.getEmployeeById(3));

//        EmployeeElectronicRelation  eer=new EmployeeElectronicRelation();
//        System.out.println("enter How many rechords You want to enter");
//        int i=s.nextInt();
//         while(i-->0)
//         {
//          employeeService.addEmployee(eer.addData());
//         }
//         System.out.println("Done");
         System.exit(0);
	}
}
