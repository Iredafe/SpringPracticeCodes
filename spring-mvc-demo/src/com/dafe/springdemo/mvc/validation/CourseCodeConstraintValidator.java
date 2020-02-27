package com.dafe.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dafe.springdemo.mvc.validation.CourseCode;

public class CourseCodeConstraintValidator implements
ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCode) {
		coursePrefix = theCode.value();
		
	}

	@Override
	public boolean isValid(String theCode, 
			ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;
		if (theCode !=null) {
		result=	theCode.startsWith(coursePrefix);
		}
		else {
	result =true;		
		}
		
		return result;
		}
}
