package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileRepo.FileRepository;
import com.example.demo.entity.FileData;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public void saveFileData(MultipartFile file) {
		// TODO Auto-generated method stub
		System.out.println("In Service Layer...");
		
		FileData filedata=new FileData();
		//filedata.setFid(123);
		
		filedata.setFname(file.getOriginalFilename());
		filedata.setFtype(file.getContentType());
		try {
			filedata.setFdata(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fileRepository.save(filedata);
	}

}
