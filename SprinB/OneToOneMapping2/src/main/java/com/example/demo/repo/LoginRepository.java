package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Login;

 public interface LoginRepository extends JpaRepository<Login,Integer>
 {
	 Login findByUnameAndPass(String uname,String pass);
     //internally generate query:select from Login where uname=? and 
	 //pass=?
 
 }
