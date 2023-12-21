package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.StudentDao.StudentDao;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;
	
	@Override
	public void saveStudentData(Student s) {
	
     System.out.println("Student data in service layer...."+" "+s);	
	 dao.saveStudentData(s);
	}

	@Override
	public List<Student> getAllStudentInServ() {
		
	 List<Student> slist1= dao.getAllStudent();
		
	return slist1;
	
	}

}
