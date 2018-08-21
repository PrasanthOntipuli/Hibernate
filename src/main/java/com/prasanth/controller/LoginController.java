package com.prasanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/home")
public class LoginController {

	@RequestMapping(value="*", method=RequestMethod.GET)
	public ModelAndView getTheHomepage()
	{
		ModelAndView mav=new ModelAndView();
		System.out.println("reached Home page");
		mav.setViewName("Home");
		return  mav;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView loginpage()
	{
		System.out.println("reached success page");
		return new ModelAndView("success");
	}
}
