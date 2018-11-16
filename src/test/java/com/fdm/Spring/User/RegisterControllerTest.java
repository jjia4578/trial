package com.fdm.Spring.User;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class RegisterControllerTest {
	
	@Mock //=mock(EntityManagerFactory.class)
	private UserDao uDao;
	@InjectMocks
	private RegisterController rc = new RegisterController();
	
	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void return_GoToRegister() {

		RegisterController rc = new RegisterController();
		Model mockModel = mock(Model.class);
		String nextPage = rc.goToRegister(mockModel);
		assertEquals("register", nextPage);
	}

	@Test
	public void given_registerRequest_when_passwordIsEmpty_then_goesToFailure() {
	}

	@Test
	public void given_registerRequest_when_usernameAlreadyExists_then_goesToFailure() {
	}

	@Test
	public void given_registerRequest_when_usernameIsBlank_then_goesToFailure() {
		RegisterController rc = new RegisterController();
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("");
		when(mockUser.getPassword()).thenReturn("ExamplePassword");
		when(uDao.get("")).thenReturn(null);
//		String nextPage = "failure";
//		when(rc.Register(mockUser)).thenReturn(nextPage);
		String nextPage = rc.Register(mockUser);


		assertEquals("failure", nextPage);
	}
	

}
