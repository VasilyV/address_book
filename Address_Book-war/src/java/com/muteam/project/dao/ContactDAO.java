package com.muteam.project.dao;

import com.muteam.project.entity.Contact;
import com.muteam.project.entity.Person;
import java.util.Collection;

/**
 * Used to get an access to SQL data base table "contact"
 * (i.e. information regarding phone number and email of a person).
 * Interface form allows to develop different implementations if it is needed further. 
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */

public interface ContactDAO {

    public Long addContact(Contact contact);
	
    public Contact getContact(Long contactId);
	
    public void modifyContact(Contact contact);
	
    public void deleteContact(Contact contact);
	
    public Collection<Contact> findContact(Contact contact);
	
    public Collection<Contact> getAllContactsForPerson(Person person);
}