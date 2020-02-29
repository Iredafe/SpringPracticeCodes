package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {
		//create student object
		System.out.println("create new student object...");
		
		Student tempStudent = new Student("Pearl", "Kumbi", "pearlkum@dafe.com");
		
		//start a transaction
		session.beginTransaction();
		
		//save student object
		
		System.out.println("saving the student...");
		System.out.println(tempStudent);
		session.save(tempStudent);
		
		//commit transaction
		session.getTransaction().commit();

		//My New Code
		
		// Find out what the primary key is
		
		System.out.println("Saved student. Generate id: " + tempStudent.getId());
		
		
		//let us get a new session
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		//retrieve students based on the Id: primary key
		System.out.println("\nGetting student with id: " + tempStudent.getId());
		
		Student myStudent = session.get(Student.class, tempStudent.getId());
		
		System.out.println("Get complete: " + myStudent);
		
		
		//commit the transaction
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		
	}finally{
		
		factory.close();
	}
	
	}

}
