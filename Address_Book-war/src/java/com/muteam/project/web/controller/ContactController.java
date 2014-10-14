package com.muteam.project.web.controller;

import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.muteam.project.facade.PersonFacade;
import com.muteam.project.facade.ContactFacade;
import com.muteam.project.view.PersonView;
import com.muteam.project.view.ContactView;

/**
 * Handles requests in regard to operations with a chosen person's
 * contact (i.e., "Edit", "Delete"), requests to add a new contact
 * for a chosen person (i.e., "Add") or request to return to the main page
 * (i.e., "Back").
 *
 * @version   1.0 13 Oct 2014
 * @author   Vasily Vlasov
 */

public class ContactController extends AbstractController {

    private PersonFacade personFacade;
    private ContactFacade contactFacade;

    public void setPersonFacade(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }
    
    public void setContactFacade(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        int answer = checkAction(arg0);
        if (answer == 1) {
            long personId = Integer.parseInt(arg0.getParameter("personId"));
            PersonView person = personFacade.getPerson(personId);
            Collection<PersonView> list = new ArrayList<>();
            list.add(person);
            Map<String, Collection<PersonView>> data = new HashMap<>();
            data.put("personsList", list);
            return new ModelAndView("ContactsAddFrame", data);
        }
        
        if(answer == 2) {
            if (arg0.getParameter("contactId") != null) {           
                long contactId = Integer.parseInt(arg0.getParameter("contactId"));
                ContactView contact = contactFacade.getContact(contactId);
                Collection<ContactView> list = new ArrayList<>();
                list.add(contact);
                Map<String, Collection<ContactView>> data = new HashMap<>();
                data.put("contactsList", list);
                return new ModelAndView("ContactsEditFrame", data);
            }      
        }
        
        if (answer == 3) {
            if (arg0.getParameter("contactId") != null) {
                long contactId = Integer.parseInt(arg0.getParameter("contactId"));
                contactFacade.deleteContact(contactFacade.getContact(contactId));
            }
        }
        
        if (answer == 4) {
            Collection<PersonView> list = personFacade.findPersons();
        Map<String,Collection<PersonView>>  data = new HashMap<>();
        data.put("personsList", list);
        return new ModelAndView("PersonsFrame", data);
        }
        
        long personId = Integer.parseInt(arg0.getParameter("personId"));
        Collection<PersonView> l = new ArrayList<>();
	PersonView person = personFacade.getPerson(personId);
	l.add(person);
        Map<String, Collection<PersonView>> data = new HashMap<>();
        data.put("personsList", l);
        return new ModelAndView("ContactsFrame", data);
    }
    
    private int checkAction(HttpServletRequest req) {
        if (req.getParameter("Add") != null) {
            return 1;
        }
        if (req.getParameter("Edit") != null) {
            return 2;
        }
        if (req.getParameter("Delete") != null) {
            return 3;
        }
        if (req.getParameter("Back") != null) {
            return 4;
        }
        return 0;
    }
}