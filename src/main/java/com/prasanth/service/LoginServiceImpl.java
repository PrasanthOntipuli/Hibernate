package com.prasanth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasanth.DAO.LoginDAO;
import com.prasanth.DTO.LoginDTO;
import com.prasanth.model.Login;
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDTO loginDTO;
	@Override
	public void saveLogin(Login login) {
		loginDTO.saveLogin(login);
	}

	@Override
	public void chaingePassword(String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sharePasswordChaingingUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
