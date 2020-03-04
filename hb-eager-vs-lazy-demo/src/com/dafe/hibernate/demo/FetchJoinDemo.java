package com.dafe.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dafe.hibernate.demo.entity.Course;
import com.dafe.hibernate.demo.entity.Instructor;
import com.dafe.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
		
		int theId = 1;
		
		Query <Instructor>  query = 
				session.createQuery("select i from Instructor i " 
						+ "JOIN FETCH i.courses " 
							+ "where i.id =:theInstructorId",
						Instructor.class);
		
		//set parameter on query
		
		query.setParameter("theInstructorId", theId);
		
		//execute query and get instructor
		Instructor tempInstructor= query.getSingleResult();
		
		System.out.println("dafe's code : Instructor :" + tempInstructor );
		 
		//commit transaction
		session.getTransaction().commit();
		
		//close session 
		
		session.close();
		System.out.println("the session is now closed");
		
		//get instructor course
		
				System.out.println("dafe's code : getting courses: " + tempInstructor.getCourses());
				System.out.println("dafe's code : Done!!");
						
		
	}finally{
		
		
		//add clean up code
		session.close();
		factory.close();
	}
	
	}

}
