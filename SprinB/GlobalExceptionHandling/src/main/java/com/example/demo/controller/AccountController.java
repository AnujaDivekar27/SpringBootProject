package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.exception.AccountNotFound;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/getAccount/{aname}/{email}")
	public Account getAccountData(@PathVariable String aname,@PathVariable String email) throws AccountNotFound
	{
	  System.out.println("Account name and email in controller");	
	  System.out.println("Account Name:"+" "+aname);
	  System.out.println("Account Email:"+" "+email);
	  System.out.println("--------------------------------------");	
	 
	  Account account=accountService.getAccountData(aname, email);
	  System.out.println("Account id:"+" "+account.getAid());
	  
	  //Throws NullPointerException:for wrong email/acname
	  //If Exception not handled then  error will show on postman nd terminate programe
      //"com.example.demo.exception.AccountNotFound: invalid account name and email	  
	  
	  return account;
    }
}