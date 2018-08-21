package com.prasanth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Desktop_Details")
public class Desktop implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int Desktop_id;
	private String displayPixles;
	private String Core;
}
