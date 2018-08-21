package com.prasanth.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prasanth.model.Employee;
import com.prasanth.service.EmployeeService;


@RestController
@RequestMapping(value="restcnt")
public class GetDataJsonCalls {

	@Autowired
	EmployeeService employeeService;
	
	{
		System.out.println("data is in update 2 ");
	}
	
    @Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/getEmployeeById",produces=MediaType.APPLICATION_JSON_VALUE,
	                       consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST )
	public @ResponseBody Employee getEmployeeData(@RequestBody(required=false) String empId,Model model)
		{
		int id=0;
		try
		{
	     id=Integer.parseInt(empId);
	     System.out.println("data reseved"+(id+1));
		}
		catch(Exception ex)
		{
			System.out.println("error string    :"+id+" is it null"+ex);
//			System.exit(1);
		}
//		System.out.println("before service");
		Employee e = null;
		try {
		     e=employeeService.getEmployeeById(id);
		     return e;
		    
		} catch (Exception ex) {
			// TODO: handle exception
			//System.out.println("execption " +ex);
		}
		
		if(e==null)
		{
			System.out.println("DB is not hit or session is been expired");
		}
		else 
		{
//			System.out.println("Employee details"+e.toString());
		}
		return e;
		
	}
	
	@RequestMapping(value = "/deleteEmployeeById/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Integer deleteEmployeeById(@PathVariable("id") int itemId, Model model,HttpServletResponse response)
      {
		   
		System.out.println("Delete employee by id"+itemId);
		try {
			int i=employeeService.deleteByID(itemId);
			return i;
		} catch (HibernateException exe) {
			System.out.println("Hibernate execption"+exe);
		}
	   
     	return 0;
      }
	
	@RequestMapping(value="/updateEmployee", headers="Accept=application/json" )
	public void updateEmployee(@RequestBody	String employee )
	{
		ObjectMapper obj=new ObjectMapper();
		Employee emp=null;
		try {
			emp = obj.readValue(employee, Employee.class);
			employeeService.updateEmployee(emp);
			System.out.println(emp.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (HibernateException ex) {
			// TODO: handle exception
			System.out.println("hiber nate erxecption"+ex);
		}
		System.out.println("Reached Update Method of Controller");
		System.out.println(emp.getName());
	}
	
}
