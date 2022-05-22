package com.org.many2many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class M2MDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		Employee employee1=new Employee();
		employee1.setEmployeeId(101);
		employee1.setEmployeeName("Pankaj");
		
		Employee employee2=new Employee();
		employee2.setEmployeeId(102);
		employee2.setEmployeeName("Ram");
		
		Employee employee3= new Employee();
		employee3.setEmployeeId(103);
		employee3.setEmployeeName("Shyam");
		
		
		Project project1=new Project();
		project1.setProjectId(201);
		project1.setProjectName("Liberary Management");
		
		Project project2=new Project();
		project2.setProjectId(202);
		project2.setProjectName("School Managment");
		
		Project project3=new Project();
		project3.setProjectId(203);
		project3.setProjectName("Chatbot");
		
		Project project4=new Project();
		project4.setProjectId(204);
		project4.setProjectName("Dummy Project");
		
		Project project5=new Project();
		project5.setProjectId(205);
		project5.setProjectName("Attandence Managment");
		
		List<Employee> employeeList1=new ArrayList<Employee>();
		List<Project> projectList1=new ArrayList<Project>();
		
		employeeList1.add(employee1);
		employeeList1.add(employee2);
		
		projectList1.add(project1);
		projectList1.add(project2);
		
		employee1.setProjects(projectList1);
		project2.setEmployees(employeeList1);
		
		
		
		Transaction transaction=session.beginTransaction();
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(project1);
		session.save(project2);
		session.save(project3);
		session.save(project4);
		session.save(project5);
		
		transaction.commit();
		
		session.close();
		factory.close();
	}

}
