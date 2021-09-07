package com.spring.professional.exam.tutorial.module03.question01.unchecked.dao;

import com.spring.professional.exam.tutorial.module03.question01.unchecked.ds.Person;
import com.spring.professional.exam.tutorial.module03.question01.unchecked.exception.PersonFileSystemException;
import com.spring.professional.exam.tutorial.module03.question01.unchecked.exception.PersonInvalidException;
import com.spring.professional.exam.tutorial.module03.question01.unchecked.exception.PersonStoreException;

public class PersonDao {
	
	public void save(Person person) {
		if(!valid(person)) {
			throw new PersonInvalidException();
		}
		if(!store(person)) {
			throw new PersonStoreException();
		}
		if(!fileSystemActive(person)) {
			throw new PersonFileSystemException();
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
