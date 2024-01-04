package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootJavaToJasonAndViceVersaApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(SpringBootJavaToJasonAndViceVersaApplication.class, args);

	  System.out.println("==========Json To Java Conversion==========");
	  System.out.println("=============================================================");
	  
	  ObjectMapper objectMapper =new ObjectMapper();
	  
	  /*String str="{\"id\":1,\"name\":\"anuja\",\"address\":\"pune\"}";
	  System.out.println("Json data in string format:"+" "+str);
	  
	  Employee employee=objectMapper.readValue(str, Employee.class);
	  System.out.println("Json object into Pojo class object:"+" "+employee);
	
	  System.out.println("==========Java To Json Conversion==========");
	  System.out.println("=============================================================");
	  
	  String str1=objectMapper.writeValueAsString(employee);
	  System.out.println("Jason data in string format:"+" "+str1);
	  -----------------------------------------------------------------------------------
	  */
	  
	  //---------------------------------------------------------------------------------

	  System.out.println("==========Json To Java Conversion In oneTo Mapping==========");
	  System.out.println("=============================================================");
	  
      String str="{\"id\":1,\"name\":\"anuja\",\"state\":\"maharashtra\",\"address\":{\"id\":1,\"city\":\"pune\"}}";	  
	  System.out.println("Json data in string format:"+" "+str);
	  
	  Employee employee=objectMapper.readValue(str, Employee.class);
	  System.out.println("Json object into Pojo class object:"+" "+employee);
	
	  System.out.println("==============================================================================================");
	  System.out.println("==========Java To Json Conversion In oneTo Mapping==========");
	  System.out.println("=============================================================");
	 
	  String str1=objectMapper.writeValueAsString(employee);
	  System.out.println("Jason data in string format:"+" "+str1);
	
	
	}

}
