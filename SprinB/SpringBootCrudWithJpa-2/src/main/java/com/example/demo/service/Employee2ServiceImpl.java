package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee2;
import com.example.demo.repo.Employee2Repository;

@Repository
public class Employee2ServiceImpl implements Employee2Service{

	@Autowired
	private Employee2Repository repoemp2;
	
	@Override
	public void addEmployeeInfo(Employee2 employee) {
	  
	  System.out.println("Emplyee2 in Service Layer.."+" "+employee);
	  repoemp2.save(employee);	
	  
	}

	@Override
	public  void updateEmployeeInfo(Employee2 employee) {
		
	  repoemp2.save(employee);	
	  
	  
		
		
	}

	@Override
	public List<Employee2> getAllEmp() {
	
		System.out.println("All employee details in service layer:");
		System.out.println(repoemp2.findAll());
		
		return repoemp2.findAll(); 
	}

	@Override
	public Employee2 getSingleEmp(int id) {
		System.out.println("Employee2 id in service layer:"+" "+id);
		
		//findById:returns optional
		return (Employee2)repoemp2.findById(id).get();
	}

}
