package com.example.demo.service;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.exception.AccountNotFound;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public Account getAccountData(String aname, String email) throws AccountNotFound {
	
	 if("admin".equals(aname)&& "admin@gmail.com".equals(email))	
	 {
	   Account account=new Account();
	   account.setAid(1); account.setAname("admin");
	   account.setAtype("saving");
	   account.setEmail("admin@gmail.com");
		
	  return account;
	}
	else
	{	 
	 throw new AccountNotFound("invalid account name and email");
	}
  }
}