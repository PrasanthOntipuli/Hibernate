package com.prasanth.DTO;

import com.prasanth.model.Login;

public interface LoginDTO {
	 void saveLogin(Login login);
	 void chaingePassword(String pass);
	 void getUserID(int id);
	 void getPassword();
	 String sharePasswordChaingingUrl();
}
