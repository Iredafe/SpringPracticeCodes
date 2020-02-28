package com.dafe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3308/hb_student_tracker?"
				+ "useSSL=false&serverTimeZone=UTC";

		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection conn = 
					DriverManager.getConnection(jdbcUrl, user, password);
		
			System.out.println("Connection Successful");
			
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}

}}
