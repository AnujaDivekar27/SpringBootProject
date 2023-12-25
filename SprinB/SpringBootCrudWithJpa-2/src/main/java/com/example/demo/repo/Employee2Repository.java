package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee2;

@Repository
public interface Employee2Repository extends JpaRepository<Employee2, Integer> {

	
}
