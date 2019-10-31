package com.agilecrm.DAO;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.agilecrm.model.Domain;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Result;

public class FreeEmailsDAO {
	public List<Domain> getFreeEmailsDAO() {
		
		System.out.println("say helo");
		//ObjectifyService.register(Email.class);
		
		List<Domain> domain = ofy().load().type(Domain.class).list();
		 
		return domain;
	}

	public void updateFreeEmailsDAO() {

	}

	public String deleteFreeEmailsDAO(Long id) {
		Result<Void> res=ofy().delete().type(Domain.class).id(id);
		System.out.println(res.toString());
		return res.toString();
		

	}
	

	public Key<Domain> createFreeEmailsDAO(Domain d) {
		Key<Domain> lid = ofy().save().entity(d).now();
		System.out.println("key is " + lid);
		return lid;
	}

}
