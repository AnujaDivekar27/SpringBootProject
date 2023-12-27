package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
	  System.out.println("User in Service Layer:"+" "+user);
	  userRepository.save(user);
	  
		
	}

	@Override
	public void userByProduct(Product product, String email) 
	{
      if(email!=null)
      {
    	User user=userRepository.findByEmail(email);
    	System.out.println("User in service layer"+" "+user);
    	
    	if(user!=null)
    	{
    		user.getProduct().add(product);
    		userRepository.save(user);
    	}
      }
	} 

	
}
