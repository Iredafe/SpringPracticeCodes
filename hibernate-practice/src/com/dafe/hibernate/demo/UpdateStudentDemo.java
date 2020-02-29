package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {

int studentId = 1;		
		// Find out what the primary key is
		
		System.out.println("Saved student. Generate id: " + studentId);
		
		
		//let us get a new session
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		//retrieve students based on the Id: primary key
		System.out.println("\nGetting student with id: " + studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		System.out.println("Updating Students");
		myStudent.setFirstName("Okocha");
		
		//commit the transaction
		
		session.getTransaction().commit();
		//New Code
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		//update email for all students
		
		session.createQuery("update Student set email='owoblow@hotmail.com'").executeUpdate();

		
		System.out.println("Done!!");
		

		session.getTransaction().commit();
		
	}finally{
		
		factory.close();
	}
	
	}

}
