package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.exception.AccountNotFound;

public interface AccountService {

	Account getAccountData(String aname,String email) throws AccountNotFound;
}
