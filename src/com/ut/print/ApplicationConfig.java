package com.ut.print;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.ut")
public class ApplicationConfig {
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(getDriverManagerDataSource());
		return jdbcTemplate;
	}

	@Bean
	public DataSource getDriverManagerDataSource(){
		String url="jdbc:mysql://localhost:3306/chequeprint";
		String userName="root";
		String password="pink";
		DriverManagerDataSource dataSource=new DriverManagerDataSource(url,userName,password);
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}
}
