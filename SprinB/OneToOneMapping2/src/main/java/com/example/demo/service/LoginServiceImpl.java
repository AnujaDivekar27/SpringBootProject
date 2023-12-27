package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Login;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.repo.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService 
{

	@Autowired
	private LoginRepository loginRepo;

	@Override
	public void saveLoginDataWithPersonInfo(Login login) {

		System.out.println("Login datails in service layer:" + " " + login);
		loginRepo.save(login);

	}

	@Override
	public Login LoginCheck(String uname, String pass) throws InvalidUserException 
	{
		// TODO Auto-generated method stub
		System.out.println("Login credentials in login controller");
		System.out.println("uname:" + " " + uname + " " + "pass:" + " " + pass);

		Login login = loginRepo.findByUnameAndPass(uname, pass);
        if(login!=null)
        {
        	return login;	
        }
        else
        {
        	//when uname nd pass are different for user from db
        	System.out.println("Check here");
        	throw new InvalidUserException("invalid username and password");
        }
		
	}
	
  }
