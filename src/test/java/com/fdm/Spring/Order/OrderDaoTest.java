package com.fdm.Spring.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.Spring.User.User;

import static org.mockito.Mockito.*;

public class OrderDaoTest {

	@Mock //=mock(EntityManagerFactory.class)
	private EntityManagerFactory mockEmf;
	@InjectMocks
	private OrderDao oDao = new OrderDao();
	
	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void adding_order_then_persists_and_cleans_up_resources() {
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Order mockOrder = mock(Order.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		

		oDao.add(mockOrder);
		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockOrder);
		verify(mockEt).commit();
		verify(mockEm).close();
		
		
	}
	
	@Test
	public void delete_order_information() {
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Order mockOrder = mockEm.find(Order.class, 3);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		oDao.deleteOrder(3);
		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).remove(mockOrder);
		verify(mockEt).commit();
		verify(mockEm).close();
		
		
	}
	
	@Test
	public void get_order_then_retrive_and_cleans_up_resources() {
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
	
		oDao.get(101);
		
		
		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Order.class,101);
		order.verify(mockEm).close();
		
		
	}
	
	@Test
	public void update_order_then_cleans_up_resources() {
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Order mockOrder = mock(Order.class);
		User mockUser = mock(User.class);
		
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Order.class,202)).thenReturn(mockOrder);
		
		
		oDao.update(202, mockUser, "1990");

		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).find(Order.class,202);
		verify(mockOrder).setUser(mockUser);
		verify(mockOrder).setOrderId(202);
		verify(mockOrder).setOrderDate("1990");
		verify(mockEt).commit();
		verify(mockEm).close();

		
		
	}
	
	

}
