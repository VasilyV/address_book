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
 * Handles requests in regard to confirming or declining adding
 * a person or editing its information: first name, last name
 * and middle name (i.e., "Ok" and "Cancel"). 
 *
 * @version   1.0 13 Oct 2014
 * @author   Vasily Vlasov
 */

public class EditAddPersonController extends AbstractController {

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
        arg0.setCharacterEncoding("utf8");
        int answer = checkAction(arg0);
        if (answer == 1) {
            if (Integer.parseInt(arg0.getParameter("personId")) != 0 ) {
                long personId = Integer.parseInt(arg0.getParameter("personId"));
                PersonView person = personFacade.getPerson(personId);
                Collection<ContactView> contacts = contactFacade.findContactsForPerson(person);
                PersonView upPerson = new PersonView();
                upPerson.setPersonId(personId);
                upPerson.setFirstName(arg0.getParameter("firstName"));
                upPerson.setLastName(arg0.getParameter("lastName"));
                upPerson.setMiddleName(arg0.getParameter("middleName"));
                upPerson.setContacts(contacts);
                personFacade.modifyPerson(upPerson);
            }
            else {
                PersonView person = new PersonView();
                Collection<ContactView> contacts = new ArrayList<>();
                person.setPersonId(0l);
                person.setFirstName(arg0.getParameter("firstName"));
                person.setLastName(arg0.getParameter("lastName"));
                person.setMiddleName(arg0.getParameter("middleName"));
                person.setContacts(contacts);
                personFacade.addPerson(person);
            }
        }
        Collection<PersonView> l = personFacade.findPersons();
        Map<String,Collection<PersonView>>  data = new HashMap<>();
        data.put("personsList", l);
        return new ModelAndView("PersonsFrame", data);
    }
    
    private int checkAction(HttpServletRequest req) {
        if (req.getParameter("Ok") != null) {
            return 1;
        }
        return 2;
    }
}

