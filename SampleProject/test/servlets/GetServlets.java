package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;


public class GetServlets extends HttpServlet {

	
		protected void doGet(HttpServletRequest req, 
				HttpServletResponse resp) throws 
		ServletException ,IOException {
		
String htmlResponse = "<html><h3> Welcome To Servlets </h3></html>";		
		
PrintWriter writer = resp.getWriter();

writer.write(htmlResponse);


super.doGet(req, resp);
}}
