package com.fdm.Spring.OrderDetail;


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

import com.fdm.Spring.User.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderDetailDaoTest {
	

	@Mock //=mock(EntityManagerFactory.class)
	private EntityManagerFactory mockEmf;
	@InjectMocks
	private OrderDetailDao odDao = new OrderDetailDao();
	
	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void adding_order_detail_persists_and_cleans_up_resources() {
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		OrderDetail mockOrderDetail = mock(OrderDetail.class);
		
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		odDao.add(mockOrderDetail);
		
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockOrderDetail);
		verify(mockEt).commit();
		verify(mockEm).close();
		
		
	}
	
//	@Test
//	public void update_orderdetail_then_cleans_up_resources() {
//		EntityManager mockEm = mock(EntityManager.class);
//		EntityTransaction mockEt = mock(EntityTransaction.class);
//		User mockUser = mock(User.class);
//		
//		
//		when(mockEmf.createEntityManager()).thenReturn(mockEm);
//		when(mockEm.getTransaction()).thenReturn(mockEt);
//		when(mockEm.find(User.class,2)).thenReturn(mockUser);
//		TypedQuery<OrderDetail> query = mockEm.createQuery("SELECT od FROM OrderDetail AS od WHERE od.order_id=:order_id", OrderDetail.class);
//		query.setParameter("order", username);
//		User user = query.getSingleResult();
//		
//		uDao.update_name(2, "Warren", "G");
//
//		
//		verify(mockEmf).createEntityManager();
//		verify(mockEm).getTransaction();
//		verify(mockEt).begin();
//		verify(mockEm).find(User.class,2);
//		verify(mockUser).setFirstName("Warren");
//		verify(mockUser).getFirstName();
//		verify(mockEt).commit();
//		verify(mockEm).close();
//
//		
//		
//	}
	


}
