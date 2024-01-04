package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
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
		
		//send file data from controller to service layer
		fileService.saveFileData(file);
		
		return "file uploaded successfully";
		
	}
	
	@GetMapping(value="/getFile/{id}")
	public ResponseEntity<?> getFileData(@PathVariable int id)
	{
		System.out.println("File id in controller:"+" "+id);
		
		//get file data from db->service->controller
		FileData fileData=fileService.getFileDataUsingId(id);
		
		//if id not present in db then fileData from service is null
		if(fileData!=null)
		{
		// System.out.println(fileData.getFname()); //null
		
		 //return filedata as byte[]
		 return  ResponseEntity.ok()
		  .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:fileName=\""+ fileData.getFname()+"\"")
		  .body(fileData.getFdata()); //send filedata into body
		}
		
		else
		{
		  //if fileData is null->shows No data present msg
		  return ResponseEntity.ok("No data present");
		}
	}
}
