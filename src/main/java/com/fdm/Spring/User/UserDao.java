package com.fdm.Spring.User;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class UserDao {
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;


	public void add(User user) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
		em.close();

	}

	public User get(int i) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, i);
		em.close();
		return user;
	}

	public User get(String username) {
		EntityManager em = emf.createEntityManager();

		TypedQuery<User> query = em.createQuery("SELECT u FROM User AS u WHERE u.username=:username", User.class);
		query.setParameter("username", username);
		List<User> user = query.getResultList();
//		em.close();
//		return user;
		if (user.size() > 0) {
			em.close();
            return user.get(0);
        } else {
        	em.close();
            return null;
        }

		
		
		
		
	}
	
	public List<String> listUserName() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<String> query = em.createQuery("SELECT u.username FROM User AS u", String.class);
		List<String> allUserName = query.getResultList();
		em.close();
		return allUserName;
	}

	public String update_name(int i, String firstName, String lastName) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, i);
		EntityTransaction et = em.getTransaction();

		et.begin();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		String newFirstName = user.getFirstName();
		String newLastName = user.getLastName();
		String newName = newFirstName + newLastName;
		et.commit();
		em.close();

		return newName;

	}

	public void deleteUser(int i) {

		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, i);
		EntityTransaction et = em.getTransaction();

		et.begin();
		user.setStatus("Non-active");
		et.commit();
		em.close();

	}

}
