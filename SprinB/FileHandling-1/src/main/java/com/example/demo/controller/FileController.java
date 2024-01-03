package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileService;//I

@RestController
public class FileController {

	@Autowired
	private FileService fileService;
	
	@PostMapping(value="/upload")
	public String getFileData(@RequestParam("file") MultipartFile file)
	{
		System.out.println("In Controller....");
		System.out.println(file.getOriginalFilename());
		fileService.saveFileData(file);
		return "file upload";
		
	}
}
