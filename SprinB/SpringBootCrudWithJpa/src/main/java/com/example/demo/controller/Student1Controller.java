package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student1;
import com.example.demo.services.Student1Service;
import com.example.exception.StudentNotFoundException;

@RestController  //combination of @RequestBody nd @Controller
public class Student1Controller {

	@Autowired
	private Student1Service student1Service;
	
	//@RequestMapping(value="/a",method=RequestMethod.POST)
	
	@PostMapping(value="/savestud") //since spring 4.3:to save data
	public String saveStudent1Data(@RequestBody Student1 s)
	{
		System.out.println("Student1 class data in controller:"+" "+s);
		
		//send student1 class data from controller->service layer
		student1Service.saveStudent1Data(s);
		
		return "student1 data stored successfully...";
		
	}
	
	@GetMapping(value="/get/{id}")
	public Student1 getStudentData(@PathVariable int id) 
	{
		
		try 
		{
		  Student1 s1= student1Service.getStudent1ById(id);
		  System.out.println("Student1 data in controller...."+" "+s1.getId());
		  return s1;
		/*if(s!=null)
		{
		  System.out.println("Student name:"+" "+s.getName());
		  return s;
		}
		else
		{
			Student1 s1=new Student1();
			s1.setErrorMsg("s1 is empty");
			
			return s1;
		}*/
		}
		catch(StudentNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		return new Student1();
	}
	
	@GetMapping(value="/getall")
	public List<Student1> getAllStudent1()
	{
		List<Student1> stud=student1Service.getAllStudent1();
		return stud ;
		
	}
	
	@PutMapping(value="/up")
	public String updateStudent(@RequestBody Student1 student)
	{
		student1Service.updateStudent1(student);
		return "update student1 successfully";
		
	}
	
	@DeleteMapping(value="/del/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		student1Service.deleteStudent(id);
		return "delete student1 successfully";
		
	}
}




