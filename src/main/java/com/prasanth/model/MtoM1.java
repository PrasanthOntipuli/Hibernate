package com.prasanth.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class MtoM1 {
@Id	
int id;
@ManyToMany
@JoinTable(name="Demo_manyToMany",joinColumns={@JoinColumn(name="demo1")}, inverseJoinColumns={@JoinColumn(name="demo2")})
List<MtoM2> mtoM2=new ArrayList<MtoM2>();

}
