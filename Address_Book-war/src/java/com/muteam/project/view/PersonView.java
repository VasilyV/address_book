package com.muteam.project.view;

import com.muteam.project.entity.*;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Keeps data about a person (i.e. last name, first name, middle name and list of contacts),
 * used in user's interface.
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */
 
public class PersonView {
	private Long personId;
	private String lastName;
	private String firstName;
	private String middleName;
	private Collection<ContactView> contacts;
	
	public PersonView(){}
	
	public PersonView(Person person, boolean all) {
	    this.personId = person.getPersonId();
		this.lastName = person.getLastName();
		this.firstName = person.getFirstName();
		this.middleName = person.getMiddleName();
		if (all) {
		    contacts = new ArrayList<>();
			Collection<Contact> conCol = person.getContacts();
			for (Contact contact : conCol) {
			    contacts.add(new ContactView(contact));
			}
		}
	}
	
	public PersonView(Person person) {
	    this(person, false);
	}
	
	public void setPersonId(Long personId) {
	    this.personId = personId;
	}
	
	public Long getPersonId() {
	    return personId;
	}
	
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	
	public String getLastName() {
	    return lastName;
	}
	
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	
	public String getFirstName() {
	    return firstName;
	}
	
	public void setMiddleName(String middleName) {
	    this.middleName = middleName;
	}
	
	public String getMiddleName() {
	    return middleName;
	}
	
	public void setContacts(Collection<ContactView> contacts) {
	    this.contacts = contacts;
	}
	
	public Collection<ContactView> getContacts() {
	    return contacts;
	}
}
	