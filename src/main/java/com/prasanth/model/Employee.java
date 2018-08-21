package com.prasanth.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Table(name="Employee_Details")
@Entity
public class Employee implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private int employeeId;
	private String name;
	private int salary;
	private List<Vechile> vechiles;
	private Address address;
	private List<Resource> resourses;//=new ArrayList<Resource>();
	private Login login;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEmployeeId() {
		return employeeId;
	}
	
	
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	
	
	@OneToMany(mappedBy="employee" ,fetch=FetchType.LAZY)
	  @JsonManagedReference("vechiles")
	public List<Vechile> getVechiles() {
		return vechiles;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Address_Fk",nullable=false)
	public Address getAddress() {
		return address;
	}
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="Electronic_Resourses" , joinColumns={@JoinColumn(name="Employee_Id")},
	inverseJoinColumns={@JoinColumn(name="Resourse_Id")})
	 @JsonIgnore
	public List<Resource> getresourses() 
	{
		return resourses;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setVechiles(List<Vechile> vechiles) {
		this.vechiles = vechiles;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setresourses(List<Resource> resourses) {
		this.resourses = resourses;
	}

	
	 
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	

    public Employee(int employeeId, String name, int salary,
			List<Vechile> vechiles, Address address, List<Resource> resourses,
			Login login) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.vechiles = vechiles;
		this.address = address;
		this.resourses = resourses;
		this.login = login;
	}


	@OneToOne(mappedBy="employee",cascade=CascadeType.ALL)
	@JsonBackReference("login")
	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	@Override
	public String toString() 
	{
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", salary=" + salary + ", vechiles=" + vechiles
				+ ", address=" + address + "]";
	}



	
	
	
	
	
	
	
	
   	
}
