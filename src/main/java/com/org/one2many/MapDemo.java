package com.org.one2many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		// Question1
		Question question1 = new Question();
		question1.setQuestionId(1212);
		question1.setQuestion("What is Java");
		// Answer1
		Answer answer1 = new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("Java is Programming Language.");
		answer1.setQuestion(question1);

		Answer answer2 = new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("With the help of Java we can create software ");
		answer2.setQuestion(question1);

		Answer answer3 = new Answer();
		answer3.setAnswerId(345);
		answer3.setAnswer("Java Has different types of frameworks. ");
		answer3.setQuestion(question1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);

		question1.setAnswers(list);

//		// Question2
//		Question question2=new Question();
//		question2.setQuestionId(242);
//		question2.setQuestion("What is Collection Framwork?");
//		//Answer2
//		Answer answer2=new Answer();
//		answer2.setAnswerId(344);
//		answer2.setAnswer("API to work with Objects in java");
//		answer2.setQuestion(question2);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(question1);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);

		transaction.commit();

		// fetching for foregion key
//		Question q=(Question)session.get(Question.class, 1212);
//		System.out.println(q.getQuestion());

		session.close();
		factory.close();
	}

}
