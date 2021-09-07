package com.spring.professional.exam.tutorial.module03.question01.checked.dao;

import com.spring.professional.exam.tutorial.module03.question01.checked.ds.Person;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.DaoFileSystemException;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.PersonInvalidException;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.PersonStoreException;

public class PersonDao {
	
	public void save(Person person) throws PersonInvalidException, DaoFileSystemException, PersonStoreException {
		
		if(!valid(person)) {
			throw new PersonInvalidException();
		}
		
		if(!fileSystemActive(person)) {
			throw new DaoFileSystemException();
		}
		
		if(!store(person)) {
			throw new PersonStoreException();
		}
		
	}
	
	private boolean valid(Person person) {
		return false;
	}
	
	private boolean store(Person person) {
		return false;
	}
	
	private boolean fileSystemActive(Person person) {
		return false;
	}
}
