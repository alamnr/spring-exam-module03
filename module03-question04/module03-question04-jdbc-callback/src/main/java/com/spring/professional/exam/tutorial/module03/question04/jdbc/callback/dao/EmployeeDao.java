package com.spring.professional.exam.tutorial.module03.question04.jdbc.callback.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.professional.exam.tutorial.module03.question04.jdbc.callback.ds.Employee;

@Repository
public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setData(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List<Employee> findEmployees(){
		return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee", 
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return new Employee(rs.getInt("employee_id"), 
								rs.getString("first_name"), rs.getString("last_name"), 
								rs.getString("email"), rs.getString("phone_number"), rs.getDate("hire_date"),
								rs.getFloat("salary"));
					}
			
		});
	}
	
	public float findAverageSalaryRowByRow() {
		AverageSalaryRowCallbackHandler averageSalaryRowCallbackHandler = new AverageSalaryRowCallbackHandler();
		
		jdbcTemplate.query("select salary from employee", averageSalaryRowCallbackHandler);
		
		return averageSalaryRowCallbackHandler.getAverageSalary();
	}
	
	public Float findAverageSalaryCalculatedOnEntireResultSet() {
		return jdbcTemplate.query("select salary from employee", new AverageSalaryResultSetExtractor());
	}
	
	public double findAverageSalaryModernImplementation() {
		return jdbcTemplate.queryForList("select salary from employee",Double.class)
				.stream().mapToDouble(Double::valueOf)
				.average().orElse(0f);
	}
	
	public double findAverageSalarySqlLevel() {
		return jdbcTemplate.queryForObject("select avg(salary) from employee", Double.class);
	}
	
	public int findEmployeeIdFromEmail(String email) {
		return jdbcTemplate.query(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						 return con.prepareStatement("select employee_id from employee where email = ?");
					}
				}, 
				new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, email);						
					}
				},
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next())
                            return rs.getInt("employee_id");
                        else
                            throw new SQLException("Unable to find id based on email");
				
					}
				}
				);
	}
	
	private static class AverageSalaryRowCallbackHandler  implements RowCallbackHandler {
		
		private float salarySum = 0;
		private int salariesCount = 0;
		

		@Override
		public void processRow(ResultSet rs) throws SQLException {
			salarySum += rs.getFloat("salary");
			++salariesCount;
		}
		
		public float getAverageSalary() {
			return salarySum/salariesCount;
		}
		
	}
	
	private static class AverageSalaryResultSetExtractor implements ResultSetExtractor<Float>{

		@Override
		public Float extractData(ResultSet rs) throws SQLException, DataAccessException {
			float salarySum = 0;
			float salariesCount = 0;
			
			while(rs.next()) {
				salarySum += rs.getFloat("salary");
				++salariesCount;
			}
			
			return salarySum / (float)salariesCount;
		}
		
	}
}
