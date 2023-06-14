package com.info_gateway.dev.webreservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class DBConfig implements TransactionManagementConfigurer {
	/* @Value("${spring.datasourcce.driver-class-name}") */
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/* @Value("${spring.datasource.url}") */
	String dbURL = "jdbc:sqlserver://211.119.240.249;databaseName=RESERVATION";
	/* @Value("${spring.datasource.username}") */
	String dbUser = "sa";
	/* @Value("${spring.datasource.password}") */
	String dbPasswd = "DBmessa!";	
	
	
	
	@Bean
	public DataSource dataSource()	{
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(dbURL);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPasswd);
		
		return dataSource;
	}
	
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager()	{
		return new DataSourceTransactionManager(dataSource());
	}

}
