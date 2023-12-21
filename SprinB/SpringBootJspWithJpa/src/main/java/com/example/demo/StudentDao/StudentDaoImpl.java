package com.example.demo.StudentDao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public void saveStudentData(Student s) {

		System.out.println("Student data in Dao layer...." + " " + s);
		Session session = sf.openSession();
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Student data inserted successfully...");

	}

	@Override
	public List<Student> getAllStudent() {
		// return slist to service layer

		Session session = sf.openSession();
		Query query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		return slist;

	}

}
