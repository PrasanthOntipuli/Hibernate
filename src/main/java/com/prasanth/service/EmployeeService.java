package com.prasanth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prasanth.model.Employee;
@Service
public interface EmployeeService {

	public void addEmployee(Employee employee );
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployees();
    int deleteByID(int id);
    int updateEmployee(Employee employee);
}
