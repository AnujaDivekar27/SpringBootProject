package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Login;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value="/saveLogin")
	public String saveLoginDataWithPerson(@RequestBody Login login)
	{
		System.out.println("Login Deatails In Controller...");
		loginService.saveLoginDataWithPersonInfo(login);
		
		return "saved login data successfully";
		
	}
	
    @GetMapping(value="/login")
    public Login getLoginData(@RequestParam String uname,@RequestParam String pass)
    {
    	
    	System.out.println("Login credentials in login controller");
    	System.out.println("uname:"+" "+uname+" "+"pass:"+" "+pass);
    	try 
    	{
    	  Login login=loginService.LoginCheck(uname,pass);
    	  //System.out.println(login.getUname());
		
    	  return login;
    	
    	}catch(InvalidUserException e)
    	{
    	  System.out.println(e.getMessage());	
    	}
		return new Login();
    }
}
