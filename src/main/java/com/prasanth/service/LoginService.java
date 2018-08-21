package com.prasanth.service;

import org.springframework.stereotype.Service;

import com.prasanth.model.Login;
@Service
public interface LoginService {

		 void saveLogin(Login login);
		 void chaingePassword(String pass);
		 void getUserID(int id);
		 void getPassword();
		 String sharePasswordChaingingUrl();
}
