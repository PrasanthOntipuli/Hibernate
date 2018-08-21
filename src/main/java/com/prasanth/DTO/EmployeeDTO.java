package com.prasanth.DTO;

import java.io.Serializable;
import java.util.List;

import com.prasanth.model.Employee;

public interface EmployeeDTO extends Serializable
{
	public void addEmployee(Employee emp);
	public Employee getEmployeeById(int id);
	List<Employee> getEmployees();
    int deleteByID(int id);
    int updateEmployee(Employee employee);
	
}
