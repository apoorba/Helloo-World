package com.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String HomePage(){
		
		return "home";
	}
	
	@RequestMapping(value="category-list", method=RequestMethod.GET)
	public String CategoryPage(){
		
		return "category-list";
	}
	
	@RequestMapping(value="product-list", method=RequestMethod.GET)
	public String ProductPage(){
		
		return "product-list";
	}
	
	@RequestMapping(value="contact", method=RequestMethod.GET)
	public String ContactPage(){
		
		return "contact";
	}
	
	@RequestMapping(value="about", method=RequestMethod.GET)
	public String AboutPage(){
		
		return "about";
	}
	
	
}
