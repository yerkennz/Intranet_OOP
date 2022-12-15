package Exceptions;

import Main.Course;

public class CreditLimit extends Exception{
	
	public CreditLimit(Course course, int credit) {
		super(String.format("Credit overloading with "+course.getCredits()+"Limit is "+credit));
	}
}
