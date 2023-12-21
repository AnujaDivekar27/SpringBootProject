package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Student;


public interface StudentService {

	void saveStudentData(Student s);
	
	List<Student> getAllStudentInServ();
}
