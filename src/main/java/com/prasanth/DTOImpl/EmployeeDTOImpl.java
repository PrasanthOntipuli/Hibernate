package com.prasanth.DTOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prasanth.DAO.EmployeeDAO;
import com.prasanth.DTO.EmployeeDTO;
import com.prasanth.model.Employee;


@Component("employeeDto")
public class EmployeeDTOImpl implements EmployeeDTO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3286177041202760287L;
	@Autowired
	EmployeeDAO employeeDAO;//=new EmployeeDAOImpl();
	
	public void addEmployee(Employee emp)
	{
		employeeDAO.addEmployee(emp);
	}

	public Employee getEmployeeById(int id) {
		
		return employeeDAO.getEmployeeById(id);
	}

	public List<Employee> getEmployees() {

		return employeeDAO.getEmployees();
	}

	@Override
	public int deleteByID(int id) {
		
		return employeeDAO.deleteByID(id);
	}

	@Override
	public int updateEmployee(Employee employee) {
	
		return employeeDAO.updateEmployee(employee);
	}
}
