package com.spring.professional.exam.tutorial.module03.question02.application.server.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDatasource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<String> findAllEmployeeEmail(){
		return jdbcTemplate.queryForList("select email from employee", String.class);
	}
}
