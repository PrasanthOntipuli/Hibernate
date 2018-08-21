package com.prasanth.DTOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prasanth.DAO.LoginDAO;
import com.prasanth.DTO.LoginDTO;
import com.prasanth.model.Login;
@Component
public class LoginDTOImpl  implements LoginDTO
{

	@Autowired
	LoginDAO loginDAO;
	
	public void saveLogin(Login login) 
	{
		loginDAO.saveLogin(login);
	}

	public void chaingePassword(String pass) {
		// TODO Auto-generated method stub
		
	}

	public void getUserID(int id) {
		// TODO Auto-generated method stub
		
	}

	public void getPassword() {
		// TODO Auto-generated method stub
		
	}

	public String sharePasswordChaingingUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
