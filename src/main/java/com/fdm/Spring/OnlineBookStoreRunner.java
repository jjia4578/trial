package com.fdm.Spring;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdm.Spring.Book.Book;
import com.fdm.Spring.Book.BookDao;
import com.fdm.Spring.Order.Order;
import com.fdm.Spring.Order.OrderDao;
import com.fdm.Spring.OrderDetail.OrderDetail;
import com.fdm.Spring.OrderDetail.OrderDetailDao;
import com.fdm.Spring.OrderDetail.OrderDetailId;
import com.fdm.Spring.User.User;
import com.fdm.Spring.User.UserDao;

public class OnlineBookStoreRunner {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		UserDao uBean = (UserDao) ctx.getBean("userDaoBean");
		User u1 = new User("chris", "brown", "abc", "male");
		User u2 = new User("bob", "nothing", "abc1", "female");
		User u3 = new User("kobe", "byrant", "abc2", "male");
		User u4 = new User("diam", "libero", "abc3", "male");
		User u5 = new User("dapibus", "lambo", "abc4", "male");
		User u6 = new User("ipsum", "brito", "abc5", "female");
		User u7 = new User("feugiat", "taco", "abc6", "male");
		User u8 = new User("est", "beef", "abc7", "male");
		User u9 = new User("pulvinar", "lamb", "abc8", "female");

		uBean.add(u1);
		uBean.add(u2);
		uBean.add(u3);
		uBean.add(u4);
		uBean.add(u5);
		uBean.add(u6);
		uBean.add(u7);
		uBean.add(u8);
		uBean.add(u9);

		BookDao bBean = (BookDao) ctx.getBean("bookDaoBean");
		Book b1 = new Book(101, "YouAndMe", 25.5, "BlackWhite");
		Book b2 = new Book(202, "NothingElse", 28, "Nobody");
		Book b3 = new Book(303, "CommonSense", 30, "KingSnow");
		Book b4 = new Book(404, "dolor", 32, "amet");
		Book b5 = new Book(505, "consectetur", 12, "adipiscing");
		Book b6 = new Book(606, "Duis", 38, "Etiam");
		Book b7 = new Book(707, "lorem", 24, "mauris");
		Book b8 = new Book(808, "bibendum", 56, "euismod");

		bBean.add(b1);
		bBean.add(b2);
		bBean.add(b3);
		bBean.add(b4);
		bBean.add(b5);
		bBean.add(b6);
		bBean.add(b7);
		bBean.add(b8);

		OrderDao oBean = (OrderDao) ctx.getBean("orderDaoBean");

		Order d1 = new Order(1001, u1, "2006-11-08");
		Order d2 = new Order(1002, u2, "2007-11-08");
		Order d3 = new Order(1003, u3, "2010-08-08");
		Order d4 = new Order(1004, u3, "2013-02-23");
		Order d5 = new Order(1005, u4, "2018-06-08");
		Order d6 = new Order(1006, u5, "2000-05-08");
		Order d7 = new Order(1007, u6, "2001-04-08");
		Order d8 = new Order(1008, u7, "2002-03-08");
		Order d9 = new Order(1009, u8, "2003-09-08");
		Order d10 = new Order(1010, u9, "2004-10-08");
		Order d11 = new Order(1011, u9, "2005-10-08");

		oBean.add(d1);
		oBean.add(d2);
		oBean.add(d3);
		oBean.add(d4);
		oBean.add(d5);
		oBean.add(d6);
		oBean.add(d7);
		oBean.add(d8);
		oBean.add(d9);
		oBean.add(d10);

		OrderDetailId odId1 = new OrderDetailId(d1, b1);
		OrderDetail od1 = new OrderDetail(odId1, 3);
		OrderDetailId odId2 = new OrderDetailId(d2, b2);
		OrderDetail od2 = new OrderDetail(odId2, 2);
		OrderDetailId odId3 = new OrderDetailId(d2, b3);
		OrderDetail od3 = new OrderDetail(odId3, 2);
		OrderDetailId odId4 = new OrderDetailId(d3, b3);
		OrderDetail od4 = new OrderDetail(odId4, 2);

		OrderDetailDao odBean = (OrderDetailDao) ctx.getBean("orderDetailDaoBean");
		odBean.add(od1);
		odBean.add(od2);
		odBean.add(od3);
		odBean.add(od4);

		System.out.println(uBean.get("abc"));

	}

}
