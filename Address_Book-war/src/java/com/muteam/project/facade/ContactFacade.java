package com.muteam.project.facade;

import com.muteam.project.view.*;
import com.muteam.project.dao.*;
import com.muteam.project.entity.Contact;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Allows to conduct all the necessary CRUD-operations with a contact
 * on a business layer.
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */
 
 public class ContactFacade {
    private ContactDAO contactDAO;
	private PersonDAO personDAO;
	
	public void setContactDAO(ContactDAO contactDAO) {
	    this.contactDAO = contactDAO;
	}
	
	public void setPersonDAO(PersonDAO personDAO) {
	    this.personDAO = personDAO;
	}
	
	public Long addContact(ContactView cView) {
	    cView.setContactId(null);
		return contactDAO.addContact(createContactFromView(cView));
	}
	
	public void modifyContact(ContactView cView) {
	    contactDAO.modifyContact(createContactFromView(cView));
	}
	
	public ContactView getContact(Long contactId) {
	    return new ContactView(contactDAO.getContact(contactId));
	}
	
	public void deleteContact(ContactView cView) {
	    contactDAO.deleteContact(contactDAO.getContact(cView.getContactId()));
	}
	
	public Collection<ContactView> findContactsForPerson(PersonView person) {
	    Collection<ContactView> cViewList = new ArrayList<>();
		Collection<Contact> cList = contactDAO.getAllContactsForPerson(personDAO.getPerson(person.getPersonId()));
		for (Contact contact : cList) {
		    cViewList.add(new ContactView(contact));
		}
		return cViewList;
	}
		
	public Contact createContactFromView(ContactView cView) {
	    Contact contact = null;
		if (cView.getContactId() != null && cView.getContactId() > 0) {
		    contact = contactDAO.getContact(cView.getContactId());
		} else {
		    contact = new Contact();
		}
		contact.setPerson(personDAO.getPerson(cView.getPersonId()));
		contact.setPhoneNumber(cView.getPhoneNumber());
		contact.setEmail(cView.getEmail());
		return contact;
	}	
		
}
	
	