package com.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ar.model.User;
import com.ar.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String LoginPage(){
		
		return "login";
	}
	
	@RequestMapping(value="sign-up", method=RequestMethod.GET)
	public String SignUpPage(){
		
		return "sign-up";
	}
	
	@RequestMapping(value="verify-user", method=RequestMethod.POST)
	public String verifyUser(Model m, @RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword){
		
		User verifiedUser= userService.verifyUser(userName, userPassword);
		
		if(verifiedUser==null){
			
			return "redirect:login";
		}
		m.addAttribute("verifiedUser", verifiedUser);
				
		return "redirect:home";
		
		
	}
	
	@RequestMapping(value="add-user", method=RequestMethod.POST)
	public String addUser(){
		
		return null;
	}
}
