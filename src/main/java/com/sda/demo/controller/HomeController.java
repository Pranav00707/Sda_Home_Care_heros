package com.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Home() {
		return "Home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "LoginForUser";
	}
	
	@GetMapping("/goToSignupOptions")
	public String goToSignupOtptions(){
		return "SignupOptions";
	}
	
	@GetMapping("/goToLoginOptions")
	public String goToLoginOptions() {
		return "LoginOptions";
	}
	
	  
}
