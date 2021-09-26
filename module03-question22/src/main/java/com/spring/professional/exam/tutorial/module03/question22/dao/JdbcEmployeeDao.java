package com.spring.professional.exam.tutorial.module03.question22.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.professional.exam.tutorial.module03.question22.ds.Employee;

@Repository
public class JdbcEmployeeDao {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveEmployee(Employee employee) {
		int numberOfRecordInserted = jdbcTemplate.update("insert into employee (employee_id, first_name,"
				+ " last_name, email, phone_number, hire_date, salary) values(?,?,?,?,?,?,?)", employee.getId(),
				employee.getFirstName(), employee.getLastName(),employee.getEmail(),employee.getPhoneNumber(),
				employee.getHireDate(),employee.getSalary());
		
		if(numberOfRecordInserted == 1 ) {
			System.out.println(String.format("Employee saved --- [%d] ", numberOfRecordInserted));
		} else {
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfRecordInserted));
		}
	}
}
