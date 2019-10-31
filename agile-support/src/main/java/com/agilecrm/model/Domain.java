package com.agilecrm.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Domain {

	@Id Long id;
	private String domainName;

	

	public Long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (long) id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
}
