package com.fdm.Spring.OrderDetail;


import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.fdm.Spring.Book.Book;
import com.fdm.Spring.Order.Order;


public class OrderDetailDao {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;


	public void add(OrderDetail orderDetail) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(orderDetail);
		et.commit();
		em.close();
		
	}
	
	public OrderDetail update( Order order, Book book, int i) {

		EntityManager em = emf.createEntityManager();
		int order_id = order.getOrderId();
		TypedQuery<OrderDetail> query = em.createQuery("SELECT od FROM OrderDetail AS od WHERE od.order_id=:order_id", OrderDetail.class);
		query.setParameter("order_id", order_id);
		OrderDetail orderDetail= query.getSingleResult();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		orderDetail.getPk().setBook(book);
		orderDetail.getPk().setOrder(order);
		et.commit();
		em.close();
		
		return orderDetail;
		
	}

}
