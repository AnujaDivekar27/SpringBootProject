package com.example.demo;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class AppConfig {

 @Bean	
 public DriverManagerDataSource getDriverManagerDataSource()
 {
	DriverManagerDataSource ds=new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/springbootbatchdemo3"); 
	ds.setUsername("root");
	ds.setPassword("root");
	return ds;
 }
 
 public LocalSessionFactoryBean getLocalSessionFactoryBean()
 {
	 LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
	 sf.setDataSource(getDriverManagerDataSource());
	 
	 Properties properties=new Properties(); //class:java.util package
	
	 properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	 properties.setProperty("hibernate.show_sql","true");
	 properties.setProperty("hibernate.hbm2ddl.auto","update");
	 
	 return sf;
 }
	 
 
}
