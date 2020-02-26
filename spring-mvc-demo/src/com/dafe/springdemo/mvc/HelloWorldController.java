package com.dafe.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show the initial HTML form

	@RequestMapping("/showForm")
	public String showForm() {
		
		return "helloworld-form";
	}
	
	//need another method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
	}
	
	//new controller method to read form data

	
	//add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		//convert data to all caps
		
		theName = theName.toUpperCase();
		
		//create the message
		
		String result = "Yo! " + theName;
		
		model.addAttribute("message", result);

		//add message to the model
		return "helloworld";
	}


	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam ("studentName") String theName, Model model) {
		
		//convert data to all caps
		
		theName = theName.toUpperCase();
		
		//create the message
		
		String result = "Hey my Friend from v3! " + theName;
		
		model.addAttribute("message", result);

		//add message to the model
		return "helloworld";
	}




}
