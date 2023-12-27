package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface UserService {

	public void addUser(User user);
	
	void userByProduct(Product product,String email);
}
