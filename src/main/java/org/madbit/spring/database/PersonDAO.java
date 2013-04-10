package org.madbit.spring.database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.madbit.spring.database.domain.Person;
import org.springframework.transaction.annotation.Transactional;

public class PersonDAO implements IPersonDAO {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addPerson(Person person) {
		logger.debug(person.getFirstName() + " " + person.getLastName());
		System.out.println(person.getFirstName() + " " + person.getLastName());
		entityManager.persist(person);
		entityManager.flush();
	}	
}
