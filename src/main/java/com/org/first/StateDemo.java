package com.org.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		// Practical of Hibernate Object State
		// Transient State
		// Persistent State
		// Detached State
		// Removed State
		System.out.println("Examples");
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		//Creating Student Object
		Student student=new Student();
		student.setId(101);
		student.setName("Peter");
		student.setCity("Delhi");
		student.setCert(new Certificate("Java Hibernate","Java","2 months"));
		// Student : Transient State
		Session session = factory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		// Student:Persistent State
		
		transaction.commit();
		
		
		session.close();
		//Detached State
		factory.close();
	}

}
