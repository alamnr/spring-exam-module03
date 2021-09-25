package com.spring.professional.exam.tutorial.module03.question20.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.professional.exam.tutorial.module03.question20.ds.Employee;

@Repository
public class EmployeeDao {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate  = new JdbcTemplate(dataSource);
	}
	
	public List<Employee> findAllEmployees(){
		return this.jdbcTemplate.query("select employee_id,first_name,last_name,email,phone_number,hire_date,salary from employee", this::mapEmployee);
	}
	
	public void saveEmployee(Employee employee) {
		if(employee.getId()<0) {
			throw new IllegalArgumentException("Employee id has to be greater than zero");
		}
		
		int numberOfSavedRecords = jdbcTemplate.update("insert  into employee (employee_id, first_name,last_name,"
				+ "email,phone_number,hire_date,salary ) values (?,?,?,?,?,?,?) ",
				employee.getId(),employee.getFirstName(),employee.getLastName(),
				employee.getEmail(),employee.getPhoneNumber(),employee.getHireDate(),employee.getSalary());
		
		if(numberOfSavedRecords == 1) {
			System.out.println(String.format("Saved employee [%d]", employee.getId()));
		} else {
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfSavedRecords));
		}
	}
	
	public void deleteAllEmployees() {
		int numberOfEmployeeDeleted = jdbcTemplate.update("delete from employee");
		
		System.out.println(String.format("Employees deleted , number of deleted rows = [%d]", numberOfEmployeeDeleted));
	}
	
	private Employee mapEmployee(ResultSet rs, int i) throws SQLException {
		return new Employee(rs.getInt("employee_id"),rs.getString("first_name"),
				rs.getString("last_name"),rs.getString("email"),rs.getString("phone_number")
				,rs.getDate("hire_date"),rs.getFloat("salary"));
	}
	
}
