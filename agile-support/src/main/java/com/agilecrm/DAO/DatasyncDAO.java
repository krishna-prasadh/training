package com.agilecrm.DAO;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.agilecrm.model.Domain;
import com.googlecode.objectify.Key;

public class DatasyncDAO {
	public List<Domain> getDatasyncDAO() {
		
		List<Domain> list=ofy().load().type(Domain.class).list();
		return list;

	}


	public void updateDatasyncDAO() {

	}

	
	public void deleteDatasyncDAO() {

	}

	
	public Key<Domain> createDatasyncDAO(Domain domain) {
		
		Key<Domain> key=ofy().save().entity(domain).now();
		
		return key;

	}
}
