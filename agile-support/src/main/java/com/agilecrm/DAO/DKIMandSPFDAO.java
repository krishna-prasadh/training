package com.agilecrm.DAO;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.agilecrm.model.Email;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

public class DKIMandSPFDAO {

	public List<Email> getDKIMandSPFDAO() {

		List<Email> list = ofy().load().type(Email.class).list();

		return list;
	}

	public Key<Email> updateDKIMandSPFDAO(Email email) {
		Key<Email> key = null;
		try {
			Key<Email> authorKey = Key.create(Email.class, email.getId());

			Query<Email> e = ofy().load().type(Email.class).filterKey("", authorKey);
			System.out.println("okay " + e);
			for (Email em : e) {
				System.out.println("email is: " + em.getEmail());
				em.setDomainName(email.getDomainName());
				em.setEmail(email.getEmail());
				key = createDKIMandSPFDAO(em);
				return key;

			}
		} catch (Exception exp) {
			System.out.println("execption is  " + exp.getMessage());
		}

		return key;
	}

	public Key<Email> createDKIMandSPFDAO(Email email) {
		Key<Email> key = ofy().save().entity(email).now();
		return key;
	}

	public String deleteDKIMandSPFDAO() {
		return "DKIMandSPFDAO";
	}

}
