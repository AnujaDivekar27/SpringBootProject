package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(value="/")
	public String getIndexPage()
	{
		System.out.println("In Student Controller......");
		System.out.println("Request Handler Method Called....."); 
		return "index";
		
	}
	
	@RequestMapping(value="/reg")
	public String saveStudentData(@ModelAttribute Student s)
	{
		System.out.println("Student data in controller"+" "+s);
		service.saveStudentData(s);
		
		//send student data from controller to service layer
		
		return "index";
	}

	@RequestMapping(value="/get")
    public String getAllStudentData()
    {
		try {
			
		
    	List<Student> slist1=service.getAllStudentInServ();
    	System.out.println("All Student data in controller"+" "+slist1);
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}

		return "allstudentdata";
    }
	
}	



