package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudWithJpaApplication.class, args);
	
		System.out.println("--------------------------------------------------------");
		System.out.println("SpringBoot Application With JPA Repositoty");
	
	
	}

}
