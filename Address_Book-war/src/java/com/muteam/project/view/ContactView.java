package com.muteam.project.view;

import com.muteam.project.entity.Contact;

/**
 * Keeps data about a contact of a person (i.e. phone number and email),
 * used in user's interface.
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */
 
public class ContactView {
    private Long contactId;
    private String phoneNumber;
    private String email;
    private Long personId;

    public ContactView() {}
	
	public ContactView(Contact contact) {
	    this.contactId = contact.getContactId();
	    this.phoneNumber = contact.getPhoneNumber();
	    this.email = contact.getEmail();
	    this.personId = contact.getPerson().getPersonId();
	}
	
	public void setContactId(Long contactId) {
	    this.contactId = contactId;
	}
	
	public Long getContactId() {
	    return contactId;
	}
	
	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
	    return phoneNumber;
	}
	
	public void setEmail(String email) {
	    this.email = email;
	}
	
	public String getEmail() {
	    return email;
    }
	
	public void setPersonId(Long personId) {
	    this.personId = personId;
	}
	
	public Long getPersonId() {
	    return personId;
	}
}
	
	    