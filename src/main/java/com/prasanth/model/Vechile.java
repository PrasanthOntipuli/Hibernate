package com.prasanth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Vechile implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="Vechile_Id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int vechileID;
    @Column(name="Vechile_Model")
    private String model;
    @ManyToOne
    @JoinColumn(name="User_Fk")
    @JsonBackReference("vechiles")
    private Employee employee;

	public int getVechileID() {
		return vechileID;
	}
	public void setVechileID(int vechileID) {
		this.vechileID = vechileID;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Vechile( String model) {
		super();
		//this.vechileID = vechileID;
		this.model = model;
	}
	public Vechile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vechile [vechileID=" + vechileID + ", model=" + model + "]";
	}
    
    
    
}
