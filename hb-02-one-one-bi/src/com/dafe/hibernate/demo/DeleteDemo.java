package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Instructor;
import com.dafe.hibernate.demo.entity.InstructorDetail;
import com.dafe.hibernate.demo.entity.Student;

public class DeleteDemo {

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
		
		
		//start a transaction
		session.beginTransaction();
		
		
		//get the instructor by their primary key/id
		int theId = 1;  
		
		Instructor tempInstructor = session.get(Instructor.class, theId);
		
		System.out.println("Found Instructor : " + tempInstructor);
		
		
		

		//delete that instructor
		if(tempInstructor != null) {
			
			System.out.println("Deleting Instructor :" + tempInstructor);
			
			//Note: this will also delete associated instructor detail 
			//because the cascadeType was set to ALL
			
		
			session.delete(tempInstructor);
		}
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
		
	}finally{
		
		factory.close();
	}
	
	}

}
