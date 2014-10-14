package com.muteam.project.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDAO {
    protected HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
	    this.template = template;
	}
	
	public HibernateTemplate getTemplate(HibernateTemplate template) {
	    return template;
	}
}