package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileRepo.FileRepository;
import com.example.demo.entity.FileData;

@Service
public class FileServiceImpl implements FileService {

	public static final String UPLOAD_DIR="C:\\Users\\Alka\\Desktop";
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
	    	
	    	Path path=Paths.get(UPLOAD_DIR+fileData.getFname());
	    	Files.write(path,fileData.getFdata());
	    	
		  return fileData;
		}
		catch(NoSuchElementException e)
	    {
		  //print No value present in console 
		  System.out.println(e.getMessage());	
		}
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
