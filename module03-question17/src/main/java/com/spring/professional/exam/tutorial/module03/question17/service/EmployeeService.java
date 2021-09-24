package com.spring.professional.exam.tutorial.module03.question17.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private DataSource dataSource;
	
	@Transactional
	public void declarativeTransaction() {
		
	}
	
	public void manualTransaction() throws SQLException {
		Connection connection = dataSource.getConnection();
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		
		try {
			
			// to do 
			
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
		}
		finally {
			connection.close();
		}
		
	}
}
