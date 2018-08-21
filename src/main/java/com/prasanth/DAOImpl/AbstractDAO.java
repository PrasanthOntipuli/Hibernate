package com.prasanth.DAOImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prasanth.model.Employee;
@Transactional
@Repository
public abstract class AbstractDAO implements Serializable
{
   @Autowired
   SessionFactory sessionFactory;


}
