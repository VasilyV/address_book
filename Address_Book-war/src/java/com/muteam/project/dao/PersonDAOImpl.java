package com.muteam.project.dao;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.muteam.project.entity.Person;

/**
 * A concrete implementation to get an access to SQL data base table "person"
 *(i.e. information regarding person's last name, first name and middle name).
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */
 
 public class PersonDAOImpl extends BaseDAO implements PersonDAO {
	
	public Long addPerson(Person person) {
	    return (long) template.save(person);
	}
	
	public Person getPerson(Long personId) {
	    return (Person) template.load(Person.class, personId);
	}
	
	public void modifyPerson(Person person) {
	    template.saveOrUpdate(person);
	}
	
	public void deletePerson(Person person) {
	    template.delete(person);
	}
	
	public Collection<Person> getAllPersons() {
	    return template.find("FROM Person ORDER BY lastName, firstName, middleName");
	}
}
	
	

    	
    
	
	