package com.prasanth.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prasanth.model.Address;
import com.prasanth.model.Employee;
import com.prasanth.model.Login;
import com.prasanth.service.EmployeeService;
import com.prasanth.service.LoginService;

@Controller("/")
public class FrountEndController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	LoginService loginService;
	
	Employee employeeper=new Employee();
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView getRegestrationpage(HttpServletRequest request,HttpServletResponse response,Employee employee)
	{
		ModelAndView model=new ModelAndView("Test1");
		model.addObject(employee);
		System.out.println("Got router");
		
		return model;
		
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public ModelAndView getEmployee(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("submit")Employee employee)
	{
		System.out.println("Rooted to the Employeee persistance page");
	    ModelAndView model=null;
	    
	    try
	    {
	    	
	    	String name=request.getParameter("name");
	    	int salary=Integer.parseInt(request.getParameter("salary"));
	    	int dn=Integer.parseInt(request.getParameter("doorNumber"));
	    	String street=request.getParameter("street");
	    	System.out.println(dn+" in street"+street);
	        employeeper.setName(name);
	        employeeper.setSalary(salary);
	        Address a=new  Address(dn, street);
	        System.out.println(a+"is the address details");
	        employeeper.setAddress(a);
	        employeeService.addEmployee(employeeper);
	        //System.out.println("data got persisted");
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("exception cought  :"+ex);
	    }
	    model = new ModelAndView("loginCredentials");
		
	
		return model;				
	}
	@RequestMapping(value="/Json",method=RequestMethod.POST)
	public ModelAndView getLogin(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mView=null;
		System.out.println();
		String pass=request.getParameter("Password1");
		employeeper.setLogin(new Login(employeeper.getEmployeeId(), pass));
		Login l=new Login();
		l.setEmployee(employeeper);
		l.setPassword(pass);
		loginService.saveLogin(l);
		System.out.println(employeeper.getEmployeeId()+"   reached   "+pass);
		mView=new ModelAndView("TestJsonAjax");
		
		return mView;
	}
//	  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//	   public String addStudent(@ModelAttribute("SpringWeb") Employee employee, 
//	   ModelMap model) {
//               
//	             model.addAttribute("name",  employee.getName());
//	             model.addAttribute("salary", employee.getSalary());
//	             Address a=new  Address(23, "Denium");
//	             employee.setAddress(a);
//	            // model.addAttribute("dNum", employee.getAddress());                	  
//             return "success";	  
//	      }
}
