package com.fdm.Spring.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.ui.Model;

public class StoreLoginControllerTest {
	
	@Test
	public void return_GoToLogin() {

		StoreLoginController sc = new StoreLoginController();
		Model mockModel = mock(Model.class);
		String nextPage = sc.goToLogin(mockModel);
		assertEquals("login", nextPage);
	}

}
