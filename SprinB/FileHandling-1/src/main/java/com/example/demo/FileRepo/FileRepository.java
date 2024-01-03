package com.example.demo.FileRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FileData;

@Repository
public interface FileRepository extends JpaRepository<FileData, Integer> 
{

}
