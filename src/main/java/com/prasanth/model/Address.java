package com.prasanth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Address_Details")
@Entity
public class Address implements Serializable{
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int doorNumber;
	private String street;
	@Id
	@Column(name="Address_PK")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoorNumber() {
		return doorNumber;
	}
	
	
	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Address( int doorNumber, String street) {
		super();
	//	this.id = id;
		this.doorNumber = doorNumber;
		this.street = street;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", doorNumber=" + doorNumber + ", street="
				+ street + "]";
	}

	
  
}
