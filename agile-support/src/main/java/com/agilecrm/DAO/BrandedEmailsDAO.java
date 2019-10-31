package com.agilecrm.DAO;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.agilecrm.model.Domain;
import com.googlecode.objectify.Key;


public class BrandedEmailsDAO {

	public List<Domain> getBrandedEmailsDAO(Domain domain) {
		List<Domain> domainlist=ofy().load().type(Domain.class).list();
		return domainlist;
	}

	public void updateBrandedEmailsDAO() {

	}

	public void deleteBrandedEmailsDAO() {

	}

	public Key<Domain> createBrandedEmailsDAO(Domain domain) {
		System.out.println("here u come  "+domain.getDomainName());

		Key<Domain> doaminKey=	ofy().save().entity(domain).now();
		return doaminKey;
	}

}
