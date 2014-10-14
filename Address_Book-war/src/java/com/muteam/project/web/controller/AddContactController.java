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
 * a new contact for a person (i.e., "Ok" and "Cancel"). 
 *
 * @version   1.0 13 Oct 2014
 * @author   Vasily Vlasov
 */

public class AddContactController extends AbstractController {

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
            ContactView contact = new ContactView();
            contact.setContactId(0l);
            long personId = Integer.parseInt(arg0.getParameter("personId"));
            contact.setPersonId(personId);
            String phoneNumber = arg0.getParameter("phoneNumber");
            String email = arg0.getParameter("email");
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            contactFacade.addContact(contact);
        }
        long personId = Integer.parseInt(arg0.getParameter("personId"));
        PersonView person = personFacade.getPerson(personId);
        Collection<PersonView> list = new ArrayList<>();
        list.add(person);
        Map<String,Collection<PersonView>>  data = new HashMap<>();
        data.put("personsList", list);
        return new ModelAndView("ContactsFrame", data);
    }
    
    private int checkAction(HttpServletRequest req) {
        if (req.getParameter("Ok") != null){
            return 1;
        }
        return 0;
    }
}
