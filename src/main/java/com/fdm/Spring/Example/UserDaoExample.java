package com.fdm.Spring.Example;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class UserDaoExample {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;

	

	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	
}
