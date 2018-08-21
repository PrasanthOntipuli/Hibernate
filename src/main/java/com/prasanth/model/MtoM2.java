package com.prasanth.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MtoM2 {
    @Id
	int id;
    @ManyToMany(mappedBy="mtoM2")
	List<MtoM1> m2m=new ArrayList<MtoM1>();
	
}
