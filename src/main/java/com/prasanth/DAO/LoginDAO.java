package com.prasanth.DAO;

import com.prasanth.model.Login;

public interface LoginDAO 
{
	
	 void saveLogin(Login login);
	 void chaingePassword(String pass);
	 void getUserID(int id);
	 void getPassword();
	 String sharePasswordChaingingUrl();
	

}
