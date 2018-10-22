package com.niutex.complaintSystem;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//tells spring to manage operations on database

@PropertySource({"classpath:database-properties.properties"})
//points on database properties file

@ComponentScan({"com.niutex.complaintSystem"})

//database configuration
public class PersistanceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.niutex.complaintSystem.entities"});
		sessionFactory.setHibernateProperties(hibernateConfig());
		
		return sessionFactory;
		
	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transacionManager = new HibernateTransactionManager();
		transacionManager.setSessionFactory(sessionFactory);
		return transacionManager;
	}
	
	Properties hibernateConfig() {
		Properties toReturn = new Properties();
		
		toReturn.setProperty("hibenate.hdm2ddl.auto", env.getProperty("hibenate.hdm2ddl.auto"));
		toReturn.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		toReturn.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return toReturn;
		
	}

}
