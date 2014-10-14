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
import com.muteam.project.view.PersonView;

/**
 * Handles requests in regard to operations with a chosen person 
 * (i.e., "Edit", "Delete" and "Contacts") or request to add a new 
 * person (i.e., "Add").
 *
 * @version   1.0 13 Oct 2014
 * @author   Vasily Vlasov
 */

public class PersonController extends AbstractController {

    private PersonFacade personFacade;

    public void setPersonFacade(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        int answer = checkAction(arg0);
   
        if (answer == 1) {
            PersonView person = new PersonView();
            person.setPersonId(0l);
            person.setFirstName("");
            person.setLastName("");
            person.setMiddleName("");
            Collection<PersonView> list = new ArrayList<>();
            list.add(person);
            Map<String, Collection<PersonView>> data = new HashMap<>();
            data.put("personsList", list);
            return new ModelAndView("PersonEditFrame", data);
        }
        
        if (answer == 2) {
            if (arg0.getParameter("personId") != null) {
                int personId = Integer.parseInt(arg0.getParameter("personId"));
                PersonView person = personFacade.getPerson(Long.valueOf(personId));
                Collection<PersonView> list = new ArrayList<>();
                list.add(person);
                Map<String, Collection<PersonView>> data = new HashMap<>();
                data.put("personsList", list);
                return new ModelAndView("PersonEditFrame", data);
            }       
        }
        
        if (answer == 3) {
            if (arg0.getParameter("personId") != null) {
                long personId = Integer.parseInt(arg0.getParameter("personId"));
                personFacade.deletePerson(personFacade.getPerson(personId));
            }
        }
        
        if (answer == 4) {
            if (arg0.getParameter("personId") != null) {
                long personId = Integer.parseInt(arg0.getParameter("personId"));
                PersonView person = personFacade.getPerson(personId);
                Collection<PersonView> list = new ArrayList<>();
                list.add(person);
                Map<String, Collection<PersonView>> data = new HashMap<>();
                data.put("personsList", list);
                return new ModelAndView("ContactsFrame", data);
            }
        }
        
        Collection<PersonView> list = personFacade.findPersons();
        Map<String,Collection<PersonView>>  data = new HashMap<>();
        data.put("personsList", list);
        return new ModelAndView("PersonsFrame", data);
    }
    
    private int checkAction(HttpServletRequest req) {
        if (req.getParameter("Add") != null)
            return 1;
        if (req.getParameter("Edit") != null)
            return 2;
        if (req.getParameter("Delete") != null)
            return 3;
        if (req.getParameter("Contacts") != null)
            return 4;
        return 0;
    }
}
