package com.org.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class FetchDemo {
	public static void main(String[] args) {

		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		
		
		// get student ID =1
		
		Student student=(Student)session.get(Student.class,1);
		
		System.out.println(student);
		
		Address address=(Address) session.get(Address.class,1);
		System.out.println(address.getStreet()+"      "+address.getCity());
		
		//closing factory
		factory.close();
	}
}
