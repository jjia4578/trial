package com.fdm.Spring.Example;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;

public class UserDaoTestExample {
	
	@Mock //=mock(EntityManagerFactory.class)
	private EntityManagerFactory emf;
	@InjectMocks
	private UserDaoExample uDao = new UserDaoExample();
	
	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	
	@Test
	public void getEmfTest() {
		EntityManagerFactory injectedEmf = uDao.getEmf();
		assertEquals(emf, injectedEmf);
		
	}

}
