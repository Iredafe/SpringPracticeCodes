package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Course;
import com.dafe.hibernate.demo.entity.Instructor;
import com.dafe.hibernate.demo.entity.InstructorDetail;
import com.dafe.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				addAnnotatedClass(Review.class).
				buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {
		
		
		//start a transaction
		session.beginTransaction();
		
		//create a course
		
		Course tempCourse = new Course("Java For Beginners");
		
		//add some reviews
		tempCourse.addReview(new Review("Great course, recommend it for newbies!"));
		tempCourse.addReview(new Review("Fantastic course, you deserve 5 stars!"));
		tempCourse.addReview(new Review("What a stupid course!"));

		
		//save the course and leverage the cascade all
		System.out.println("Saving the course!!");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		session.save(tempCourse);
		
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
