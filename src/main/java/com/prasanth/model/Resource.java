package com.prasanth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="Resourse_Details")
public class Resource implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7548312044716093955L;
		
	private int resourse_Id;
	private String type;
	private List<Employee> users;//=new ArrayList<Employee>();
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getResourse_Id() {
		return resourse_Id;
	}
	public void setResourse_Id(int resourse_Id) {
		this.resourse_Id = resourse_Id;
	}
	@Column(unique=true,nullable=false)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToMany(mappedBy="resourses", cascade=CascadeType.ALL)
	 @JsonIgnore
	public List<Employee> getUsers() 
	{
		return users;
	}
	public void setUsers(List<Employee> users) {
		this.users = users;
	}
	public Resource(String type) {
		super();
		this.type = type;
	}
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Resource [resourse_Id=" + resourse_Id + ", type=" + type
				+ ", users=" + users + "]";
	}
	
	
	
	

}
