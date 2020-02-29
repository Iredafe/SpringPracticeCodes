package com.dafe.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dafe.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		//create session

	Session session = factory.getCurrentSession();
	
	try {
		
		//start a transaction
		session.beginTransaction();
		
		//query students
		List <Student> theStudents = session.createQuery("from Student").getResultList();		
		//display students
	
		displayStudents(theStudents);
		
//query students : last name 'Kumbi'
			
		theStudents = session.createQuery("from Student s where s.lastName='Kumbi'").getResultList();

//display the students

		System.out.println("\n\n\n Students who have last name of Kumbi");
		
		displayStudents(theStudents);

		//query students : first name 'pearl' last name 'okok'
		
		theStudents = session.createQuery("from Student s where s.firstName='pearl' OR "
						+ "s.lastName='okok'").getResultList();

				//display the students

				System.out.println("\n\n\n Students who have first name of dafe or last name of Kumbi");

				displayStudents(theStudents);

				//query students : where email is like %dafe.com
				
				theStudents = session.createQuery("from Student s where s.email LIKE '%dafe.com'").getResultList();

						//display the students

						System.out.println("\n\n\n Students who have emails ending with dafe.com");

						displayStudents(theStudents);


		//commit transaction
		session.getTransaction().commit();

		
		//let us get a new session
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//commit the transaction
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		
	}finally{
		
		factory.close();
	}
	
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
}
	}

}
