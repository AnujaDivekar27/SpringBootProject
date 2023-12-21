package com.example.demo;

import java.sql.Connection;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.demo.entity.Student;


@Configuration
public class AppConfig {

 @Bean	
 public DriverManagerDataSource getDriverManagerDataSource()
 {
	DriverManagerDataSource ds=new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/springbatch27"); 
	ds.setUsername("root");
	ds.setPassword("root");
	return ds;
 }
 
 @Bean
 public LocalSessionFactoryBean getLocalSessionFactoryBean()
 {
	 LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
	 sf.setDataSource(getDriverManagerDataSource());
	 
	 Properties properties=new Properties(); //class:java.util package
	
	 properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	 properties.setProperty("hibernate.show_sql","true");
	 properties.setProperty("hibernate.hbm2ddl.auto","update");
	 
	 sf.setHibernateProperties(properties);
	 sf.setAnnotatedClasses(Student.class);
	 return sf;
 }
	 
}

