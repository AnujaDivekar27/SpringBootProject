package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student1;

@Repository
public interface Student1Repository extends CrudRepository<Student1, Integer> 
{

	//no need to create dao class 
}
