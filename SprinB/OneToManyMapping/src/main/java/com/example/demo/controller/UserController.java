package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/addUser")
	public String saveUser(@RequestBody User user)
	{
		System.out.println("User in Controller:"+" "+user);
		userService.addUser(user);
		
		return "user data stored successfully";
		
	}
	
	@PostMapping(value="/buyProduct/{email}")
	public String buyProduct(@RequestBody Product product,@PathVariable String email)
	{
		System.out.println("Product in Controller:"+" "+product);
		userService.userByProduct(product, email);
		return "user buy product";
	}


}
