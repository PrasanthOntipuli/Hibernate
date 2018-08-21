package com.prasanth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prasanth.DTO.EmployeeDTO;
import com.prasanth.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	//call DTO object in here and pass to the
	@Autowired
	EmployeeDTO employeeDTO;
	
	
	 public void addEmployee(Employee employee )
	{
	//	Employee e=new Employee("Gammela",67500);
	 employeeDTO.addEmployee(employee);	
	}
	public Employee getEmployeeById(int id)
	{
		return employeeDTO.getEmployeeById(id);
	}
	
	public List<Employee> getEmployees()
	{
		return employeeDTO.getEmployees();
	}
	@Override
	public int deleteByID(int id) {
		
		return employeeDTO.deleteByID(id);
	}
	@Override
	public int updateEmployee(Employee employee) {
		
		return employeeDTO.updateEmployee(employee);
	}
	
	
}
