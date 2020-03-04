package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Instructor;
import com.dafe.hibernate.demo.entity.InstructorDetail;
import com.dafe.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {
		//create the objects
		Instructor tempInstructor = new Instructor("Chris","John", "mikeb@dafe.com");
		
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com/mike","I love to play golf");
		
		//associate the objects0
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		
		//start a transaction
		session.beginTransaction();
		
		//save transaction
		//
		//NOTE: This will also save the details object 
		//because of Cascadee.ALL
		//	
		System.out.println("Saving instructor : " + tempInstructor);
		session.save(tempInstructor);
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
		
	}finally{
		
		factory.close();
	}
	
	}

}
