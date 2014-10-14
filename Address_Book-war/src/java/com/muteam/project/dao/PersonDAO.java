package com.muteam.project.dao;

import com.muteam.project.entity.Person;
import java.util.Collection;

/**
 * Used to get an access to SQL data base table "person"
 *(i.e. information regarding person's last name, first name and middle name).
 * Interface form allows to develop different implementations if it is needed. 
 *
 * @version   1.0 27 Oct 2014
 * @author   Vasily Vlasov
 */
 
public interface PersonDAO {
    
	public Long addPerson(Person person);
	
	public Person getPerson(Long personId);
	
	public void modifyPerson(Person person);
	
	public void deletePerson(Person person);
	
	public Collection<Person> getAllPersons();
}

 