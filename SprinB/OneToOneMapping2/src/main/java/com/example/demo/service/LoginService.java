package com.example.demo.service;

import com.example.demo.entity.Login;

public interface LoginService {

	void saveLoginDataWithPersonInfo(Login login);

	public Login LoginCheck(String uname, String pass);

}
