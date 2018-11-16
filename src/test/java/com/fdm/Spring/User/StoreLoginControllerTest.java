package com.fdm.Spring.User;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;



public class StoreLoginControllerTest {
	@Mock //=mock(EntityManagerFactory.class)
	private UserDao uDao;
	@InjectMocks
	private StoreLoginController sc = new StoreLoginController();
	
	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
		
	}
	@Test
	public void return_GoToLogin() {

		StoreLoginController sc = new StoreLoginController();
		Model mockModel = mock(Model.class);
		String nextPage = sc.goToLogin(mockModel);
		assertEquals("login", nextPage);
	}
	
	@Test
	public void given_user_does_not_exist_then_return_wrongpassword() {
		
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("ExampleName");
		when(mockUser.getPassword()).thenReturn("ExamplePassword");
		when(uDao.get("ExampleName")).thenReturn(null);
		String nextPage = sc.Login(mockUser);


		assertEquals("wrongpassword", nextPage);

	}
	@Test
	public void given_password_is_not_right_then_return_wrongpassword() {
		
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("ExampleName");
		when(mockUser.getPassword()).thenReturn("ExamplePassword");
		User mockUser2 = mock(User.class);
		when(uDao.get("ExampleName")).thenReturn(mockUser2);
		when(mockUser2.getPassword()).thenReturn("ExamplePasswordqqqqq");
		String nextPage = sc.Login(mockUser);


		assertEquals("wrongpassword", nextPage);

	}

	@Test
	public void given_registerRequest_when_usernameAlreadyExists_then_goesToFailure() {
		
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("ExampleName");
		when(mockUser.getPassword()).thenReturn("ExamplePassword");
		User mockUser2 = mock(User.class);
		when(uDao.get("ExampleName")).thenReturn(mockUser2);
		when(mockUser2.getPassword()).thenReturn("ExamplePassword");
		String nextPage = sc.Login(mockUser);


		assertEquals("welcome", nextPage);

	}

	

}
