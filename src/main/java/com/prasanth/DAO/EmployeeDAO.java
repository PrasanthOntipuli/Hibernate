package com.prasanth.DAO;

import java.util.List;

import com.prasanth.model.Employee;

public interface EmployeeDAO {

     int deleteByID(int id);
	 void addEmployee(Employee emp);
	 Employee getEmployeeById(int id);
     List<Employee> getEmployeesBySalary(int salary);
     List<Employee> getEmployeesByName(String name);
	 List<Employee> getEmployees();
	 int updateEmployee(Employee employee);
	
}
