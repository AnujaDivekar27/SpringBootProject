package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee2;

public interface Employee2Service {

  void addEmployeeInfo(Employee2 employee);
 
  
  void updateEmployeeInfo(Employee2 employee);


  List<Employee2> getAllEmp();


  Employee2 getSingleEmp(int id);
  
}
