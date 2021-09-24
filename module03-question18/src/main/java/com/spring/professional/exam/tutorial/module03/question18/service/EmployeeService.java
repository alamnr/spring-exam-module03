package com.spring.professional.exam.tutorial.module03.question18.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.professional.exam.tutorial.module03.question18.exception.CustomException;

@Service
public class EmployeeService {

	@Transactional
	public void methodWithUncheckedExceptionCausingRollBack() {
		throw new IllegalArgumentException("Test unchecked exception that caused rollback");
	}
	
	@Transactional
	public void methodWithCheckedExceptionNotCausingRollBack() throws CustomException {
		throw new CustomException("Test checked exception that will not cause rollback");
	}
	
	@Transactional(noRollbackFor = IllegalArgumentException.class)
	public void methodWithUncheckedExceptionThatNotcausingRollback() {
		throw new IllegalArgumentException("Test unchecked exception that does not caused rollback");
	}
	
	@Transactional(rollbackFor = CustomException.class)
	public void methodWithCheckedExceptionThatCauseRollback() throws CustomException {
		throw new CustomException("Test checked exception that caused rollback");
	}
}
