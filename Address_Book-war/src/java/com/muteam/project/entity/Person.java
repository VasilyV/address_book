package com.muteam.project.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents an information regarding a person: 
 * name, phone and email.
 *
 * @version   1.0 27 Sept 2014
 * @author   Vasily Vlasov
 */
 
@Entity
@Table(name = "person") 
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long personId;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	private Collection<Contact> contacts;
	
	public void setPersonId(Long personId) {
	    this.personId = personId;
    }
	
	public long getPersonId() {
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
	
	public void setContacts(Collection<Contact> contacts) {
	    this.contacts = contacts;
	}
	
	public Collection<Contact> getContacts() {
	    return contacts;
	}
}