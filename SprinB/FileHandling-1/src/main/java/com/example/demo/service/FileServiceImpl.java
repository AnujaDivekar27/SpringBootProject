package com.example.demo.service;

import java.io.IOException;
import java.util.NoSuchElementException;

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

	@Override
	public FileData getFileDataUsingId(int id) {
		System.out.println("File id in service layer:"+" "+id);
	    
		//FileData fileData;
		
	    try
		{
	       //findById(id)->return Optional	
	      //id is not present in FileData table exception occures
	    	FileData fileData=fileRepository.findById(id).get();
		  return fileData;
		}
		catch(NoSuchElementException e)
	    {
		  //print No value present in console 
		  System.out.println(e.getMessage());	
		}
		return null;
	}

}

//-----------------------------------------------------------------------
/* { when id not present in database,exception handled using try catch
"fid": 0,
"fname": null,
"ftype": null,
"fdata": null
} */
//------------------------------------------------------------------------
