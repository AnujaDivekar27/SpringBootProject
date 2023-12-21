package com.example.demo.StudentDao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDao {

	void saveStudentData(Student s);

	List<Student> getAllStudent();
	
	
}
