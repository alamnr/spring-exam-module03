package com.spring.professional.exam.tutorial.module03.question06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.professional.exam.tutorial.module03.question06.dao.EmployeeDao;

@Service
public class EmployeeReportService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void printReport() {
		System.out.println("Employee report start -------- ");
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		
		System.out.println("Employee Report Stop");
	}
	
	@Transactional
	public void printReportInTransaction() {
		System.out.println("Employee report start -------- Transactional");
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		System.out.println("findEmployeeEmails(): "+employeeDao.findEmployeeCount());
		
		System.out.println("Employee Report Stop");
	}
}
