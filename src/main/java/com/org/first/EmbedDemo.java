package com.org.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory=config.buildSessionFactory();
		//storing data in Object student1
		Student student1= new Student();
		student1.setId(14134);
		student1.setName("Ankit Tiwari");
		student1.setCity("Lucknow");
		//storing data in certificate object for syudent1
		Certificate cert1=new Certificate();
		cert1.setCourseName("Android");
		cert1.setLanguage("J2ME");
		cert1.setDuration("2 Months");
		student1.setCert(cert1);
		
		//storing data in student2 object
		Student student2 = new Student();
		student2.setId(14135);
		student2.setName("Mohit Verma");
		student2.setCity("Jaipur");
		//creating certificate object for student2
		Certificate cert2= new Certificate();
		cert2.setCourseName("Hibernate");
		cert2.setLanguage("J2EE");
		cert2.setDuration("3 Months");
		student2.setCert(cert2);
		
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();

		// object save		
		session.save(student1);
		session.save(student2);
		
		//committing transaction
		transaction.commit();
		//closing open Session
		session.clear();
		//closing factory session
		factory.close();
	}

}
