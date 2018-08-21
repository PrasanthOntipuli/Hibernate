package com.prasanth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Table(name="Employee_Login")
@Entity
public class Login implements Serializable
{
  @Id
  @Column(name="Employee_Id")
  @GeneratedValue(generator="prasDemo")
  @GenericGenerator(name="prasDemo",strategy="foreign",parameters=@Parameter(name="property",value="employee"))
  private int userID;
  private String password;
  @ColumnDefault("'User'")
  private String roal="User";
  @OneToOne
  @PrimaryKeyJoinColumn
  @JsonManagedReference("login")
  private Employee employee;
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
@Required
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getRoal() {
	return roal;
}
public void setRoal(String roal) {
	this.roal = roal;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Login(int userID, String password) {
	super();
	this.userID = userID;
	this.password = password;
}
public Login() {
	super();
	// TODO Auto-generated constructor stub
}



}
