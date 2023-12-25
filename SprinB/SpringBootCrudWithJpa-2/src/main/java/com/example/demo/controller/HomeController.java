package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee2;
import com.example.demo.service.Employee2Service;

@RestController
public class HomeController {

   @Autowired
   private Employee2Service serviceEmp;
   
   @PostMapping(value="/addEmp")
   public String addEmployeeInfo2(@RequestBody Employee2 employee)
   {
	 System.out.println("Employee2 in Controller .."+" "+employee);  
	 serviceEmp.addEmployeeInfo(employee);
	
	 return "employee added successfully....";
	   
   }
   
   @GetMapping(value ="/getAll")
   public List<Employee2>getAllEmployeeInfo2()
   {
	 List<Employee2> elist=serviceEmp.getAllEmp(); 
	 //System.out.println(elist);
	 return elist;
	   
   }
   
   @GetMapping(value ="/getSingle/{id}")
   public Employee2 getSingleEmployee(@PathVariable int id) 
   {
	 try
	 {
	   Employee2 e=serviceEmp.getSingleEmp(id); 
	   System.out.println("employee name:"+" "+e.getName());
	   return e;
	 }
	 catch(Exception e)
	 {
	   System.out.println(e); 
	 }
	 
	 return new Employee2();
   
   }
   
   @PutMapping(value="/up")
   public String updateSingleEmployee(@RequestBody Employee2 employee)
   {
	 serviceEmp.updateEmployeeInfo(employee);  
	 return "employee updated successfully...";
	   
   }
}