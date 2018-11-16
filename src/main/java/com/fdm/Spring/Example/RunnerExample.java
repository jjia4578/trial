package com.fdm.Spring.Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerExample {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		UserDaoExample uBean = (UserDaoExample) ctx.getBean("userDaoBean");
		System.out.println("bean = " + uBean + ", emf = " +uBean.getEmf());
		
		UserDaoExample uBean2 = (UserDaoExample) ctx.getBean("userDaoBean");
		System.out.println("bean = " + uBean2 + ", emf = " +uBean2.getEmf());
		
		UserDaoExample uBean3 = (UserDaoExample) ctx.getBean("userDaoBean");
		System.out.println("bean = " + uBean3 + ", emf = " +uBean3.getEmf());
		

		

	}

}
