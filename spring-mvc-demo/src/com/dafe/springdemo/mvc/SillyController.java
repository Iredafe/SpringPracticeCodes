package com.dafe.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	@RequestMapping("/processFormVersionThree")
	public String displayTheForm() {
		
		return "silly";
	}
	
}
