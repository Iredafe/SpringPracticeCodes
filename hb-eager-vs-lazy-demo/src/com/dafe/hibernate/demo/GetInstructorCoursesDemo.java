package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Course;
import com.dafe.hibernate.demo.entity.Instructor;
import com.dafe.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {
		
		
		//start a transaction
		session.beginTransaction();
		
		//get the instructor from db
		
		int theId = 10;
		Instructor tempInstructor = session.get(Instructor.class, theId);
		
System.out.println("Instructor :" + tempInstructor );
		
		
		//get instructor course
		
System.out.println("getting courses: " + tempInstructor.getCourses());
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
		
	}finally{
		
		
		//add clean up code
		session.close();
		factory.close();
	}
	
	}

}
