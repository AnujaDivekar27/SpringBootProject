package com.example.demo.services;

import java.util.List;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student1;
import com.example.demo.repo.Student1Repository;
import com.example.exception.StudentNotFoundException;

@Service
public class Student1ServiceImpl implements Student1Service {

	@Autowired
	private Student1Repository student1Repository;

	@Override
	public void saveStudent1Data(Student1 s) {
		System.out.println("Studet1 class data in service layer:" + " " + s);

		// save Student1 data from service layer
		// no need to commit()
		student1Repository.save(s);

		// save():returns an object saved in database
		System.out.println(student1Repository.save(s));

	}

	@Override
	public Student1 getStudent1ById(int id) throws StudentNotFoundException {

		Student1 student = null;
		try {
		
		// get single student1 object by passing student id
		student = student1Repository.findById(id).get();
		
        // if id not present in db->NoSuchElementException:no value present
		//returns null value to controller
		// findById->returns option
		System.out.println("Student in service layer..." + " " + student);
     	
	   }
	    catch(Exception e)
		{
		   throw new StudentNotFoundException("Student not found");
		}
		return student;
	}

	@Override
	public List<Student1> getAllStudent1() {
		
	   List<Student1>slist=(List<Student1>) student1Repository.findAll();
	   return slist;
	}

}
