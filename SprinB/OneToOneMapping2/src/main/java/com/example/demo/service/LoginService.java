package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.exception.InvalidUserException;

public interface LoginService {

	void saveLoginDataWithPersonInfo(Login login);

	Login LoginCheck(String uname, String pass) throws InvalidUserException;

}
