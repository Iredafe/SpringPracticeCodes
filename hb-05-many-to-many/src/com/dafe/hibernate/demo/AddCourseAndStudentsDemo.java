package com.dafe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Course;
import com.dafe.hibernate.demo.entity.Instructor;
import com.dafe.hibernate.demo.entity.InstructorDetail;
import com.dafe.hibernate.demo.entity.Review;
import com.dafe.hibernate.demo.entity.Student;

public class AddCourseAndStudentsDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				addAnnotatedClass(Review.class).
				addAnnotatedClass(Student.class).
						buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {
		
		
		//start a transaction
		session.beginTransaction();
		
		//get the student John from the db
int studentId = 1;		
Student tempStudent = session.get(Student.class, studentId);		

System.out.println("\nLoaded students...!!" + tempStudent);
System.out.println("\nCourses" + tempStudent.getCourses() );

//create more courses
Course tempCourse1 = new Course ("Dafe's Programming guide");
Course tempCourse2 = new Course ("Precious Secrets for Hackers");



//add student to courses

tempCourse1.addStudent(tempStudent);
tempCourse2.addStudent(tempStudent);

		//	save the students
	
System.out.println("\nSaving the course...!!");

	session.save(tempCourse1);
	session.save(tempCourse2);


//		//	System.out.println("Saved the students successfully!!" +tempCourse.getStudents());

		
		//add new students
		
		

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
