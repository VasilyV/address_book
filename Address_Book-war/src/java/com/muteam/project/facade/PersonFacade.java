package com.muteam.project.facade;

import com.muteam.project.entity.*;
import com.muteam.project.view.*;
import com.muteam.project.dao.*;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Allows to conduct all the necessary CRUD-operations with a person
 * on a business layer.
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */

public class PersonFacade {
    private PersonDAO personDAO;
	private ContactDAO contactDAO;
	private ContactFacade contactFacade;
	
	public void setPersonDAO(PersonDAO personDAO) {
	    this.personDAO = personDAO;
	}
	
	public void setContactDAO(ContactDAO contactDAO) {
	    this.contactDAO = contactDAO;
	}
	
	public void setContactFacade(ContactFacade contactFacade) {
	    this.contactFacade = contactFacade;
	}
	
	public long addPerson(PersonView pView) {
	    pView.setPersonId(null);
		return personDAO.addPerson(createPersonFromView(pView));
	}
	
	public PersonView getPerson(Long personId) {
	    return new PersonView(personDAO.getPerson(personId), true);
	}
	
	public void modifyPerson(PersonView pView) {
	    personDAO.modifyPerson(createPersonFromView(pView));
	}
	
	public void deletePerson(PersonView pView) {
	    personDAO.deletePerson(createPersonFromView(pView));
	}
	
	public void updatePersonContacts(PersonView pView) {
	    Person person = personDAO.getPerson(pView.getPersonId());
		if (pView.getContacts() != null) {
		    Collection<Contact> colCon = new ArrayList<Contact>();
			Collection<ContactView> colConView = pView.getContacts();
			for (ContactView cView : colConView) {
			    colCon.add(contactFacade.createContactFromView(cView));
			}
			person.setContacts(colCon);
			personDAO.modifyPerson(person);
		}
	}
	
	public Collection<PersonView> findPersons() {
	    Collection<Person> col = personDAO.getAllPersons();
		Collection<PersonView> colView = new ArrayList<>();
		for (Person person : col) {
		    colView.add(new PersonView(person));
		}
		return colView;
	}
	
	public Person createPersonFromView(PersonView pView) {
	    Person person = null;
		if (pView.getPersonId() != null && pView.getPersonId() > 0) {
		    person = personDAO.getPerson(pView.getPersonId());
		} else {
		    person = new Person();
			person.setContacts(new ArrayList<Contact>());
		}
		person.setLastName(pView.getLastName());
		person.setFirstName(pView.getFirstName());
		person.setMiddleName(pView.getMiddleName());
		return person; 
	}
}