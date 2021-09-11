package com.spring.professional.exam.tutorial.module03.question03.jdbc.template.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.professional.exam.tutorial.module03.question03.jdbc.template.ds.Employee;

@Repository 
public class EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<String> findAllEmployeeEmails(){
		return jdbcTemplate.queryForList("select email from employee",String.class);
	}
	
	public int findEmployeesCount() {
		return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
	}
	
	public Employee findEmployeeWithHighestSalary() {
		return jdbcTemplate.queryForObject("select * from employee order by salary desc limit 1", this::mapEmployee);
	}
	
	public Employee findFirstHiredEmployee() {
		return jdbcTemplate.queryForObject("select * from employee order  by  hire_date limit 1", this::mapEmployee);
	}
	
	public List<Employee> findEmployees(){
		return jdbcTemplate.query("select employee_id,first_name,last_name,email,phone_number,hire_date,salary "
				+ "from employee ", this::mapEmployee);
	}
	
	private Employee mapEmployee(ResultSet resultSet, int i) throws SQLException {
		return new Employee(resultSet.getInt("employee_id"), resultSet.getString("first_name"),
				resultSet.getString("last_name"), resultSet.getString("email"), 
				resultSet.getString("phone_number"), resultSet.getDate("hire_date"), 
				resultSet.getFloat("salary"));
	}

}
