package com.muteam.project.dao;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.muteam.project.entity.Contact;
import com.muteam.project.entity.Person;

/**
 * A concrete implementation to get an access to SQL data base table "contact"
 *(i.e. information regarding phone number and email of a person).
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */
 
public class ContactDAOImpl extends BaseDAO implements ContactDAO {
   
	public Long addContact(Contact contact) {
	    return (Long) template.save(contact);
	}
	
	public Contact getContact(Long contactId) {
	    return (Contact) template.load(Contact.class, contactId);
	}
	
	public void modifyContact(Contact contact) {
	    template.saveOrUpdate(contact);
	}
	
	public void deleteContact(Contact contact) {
	    template.delete(contact);
	}
	
	public Collection<Contact> findContact(Contact contact) {
	    return template.find("FROM Contact ORDER BY phoneNumber, email");
	}
	
	public Collection<Contact> getAllContactsForPerson(Person person) {
	    return template.findByNamedParam("FROM Contact contact WHERE contact.person = :person " +
		        "ORDER BY phoneNumber, email", "person", person);
	}
}
	
	    