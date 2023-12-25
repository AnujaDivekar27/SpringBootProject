package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneMapping2Application {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMapping2Application.class, args);
	
	 System.out.println("--------------------------------------------");
	 
	 System.out.println("In Main class:"+" "+"One To One Unidirectional Example");
	 System.out.println("--------------------------------------------");
	 System.out.println("Use JPQL Query Lang for Custom Query");
	}

}
