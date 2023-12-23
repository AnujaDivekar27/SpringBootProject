package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Student1;
import com.example.exception.StudentNotFoundException;

public interface Student1Service {

	public void saveStudent1Data(Student1 s);
	
	public Student1 getStudent1ById(int id) throws StudentNotFoundException;
	
	public List<Student1> getAllStudent1();
	
	public void updateStudent1 (Student1 s);
	
	public void deleteStudent(int id);
}
