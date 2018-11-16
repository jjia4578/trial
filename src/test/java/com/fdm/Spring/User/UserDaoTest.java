package com.fdm.Spring.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserDaoTest {
	
	@Mock //=mock(EntityManagerFactory.class)
	private EntityManagerFactory mockEmf;
	@InjectMocks
	private UserDao uDao = new UserDao();
	
	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
		
	}
	
		@Test
		public void adding_user_persists_and_cleans_up_resources() {
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			User mockUser = mock(User.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			
			uDao.add(mockUser);
			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).persist(mockUser);
			verify(mockEt).commit();
			verify(mockEm).close();
			
			
		}
		
		@Test
		public void get_user_then_retrive_and_cleans_up_resources() {
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
		
			uDao.get(1);
			
			
			InOrder order = inOrder(mockEmf, mockEm);
			order.verify(mockEmf).createEntityManager();
			order.verify(mockEm).find(User.class,1);
			order.verify(mockEm).close();
			
			
		}
		
		@Test
		public void list_user_name() {
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			User mockUser = mock(User.class);
			TypedQuery<String> mockString = mock(TypedQuery.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.createQuery("SELECT u.username FROM User AS u", String.class)).thenReturn(mockString);
			uDao.listUserName();


			
			verify(mockEmf).createEntityManager();
			TypedQuery<String> query = mockEm.createQuery("SELECT u.username FROM User AS u", String.class);
			verify(query).getResultList();
			verify(mockEm).close();

			
			
		}
		
		@Test
		public void get_user_by_usernmae_then_retrive_and_cleans_up_resources() {
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			TypedQuery<User> mockUser = mock(TypedQuery.class);
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.createQuery("SELECT u FROM User AS u WHERE u.username=:username", User.class)).thenReturn(mockUser);
		
			uDao.get("abc");
			
			
			
			verify(mockEmf).createEntityManager();
			TypedQuery<User> query = mockEm.createQuery("SELECT u FROM User AS u WHERE u.username=:username", User.class);
			verify(query).getSingleResult();
			verify(mockEm).close();
			
			
		}
		
		@Test
		public void update_user_name_then_cleans_up_resources() {
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			User mockUser = mock(User.class);
			
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.find(User.class,2)).thenReturn(mockUser);
			
			
			uDao.update_name(2, "Warren", "G");

			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).find(User.class,2);
			verify(mockUser).setFirstName("Warren");
			verify(mockUser).getFirstName();
			verify(mockEt).commit();
			verify(mockEm).close();

			
			
		}
		
		@Test
		public void delete_user() {
			EntityManager mockEm = mock(EntityManager.class);
			EntityTransaction mockEt = mock(EntityTransaction.class);
			User mockUser = mock(User.class);
			
			
			when(mockEmf.createEntityManager()).thenReturn(mockEm);
			when(mockEm.getTransaction()).thenReturn(mockEt);
			when(mockEm.find(User.class,2)).thenReturn(mockUser);

			
			uDao.deleteUser(2);

			
			verify(mockEmf).createEntityManager();
			verify(mockEm).getTransaction();
			verify(mockEt).begin();
			verify(mockEm).find(User.class,2);
			verify(mockUser).setStatus("Non-active");
		
			verify(mockEt).commit();
			verify(mockEm).close();

			
			
		}


}
