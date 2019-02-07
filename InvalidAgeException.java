package com.assignment.Q4_2;

public class InvalidAgeException extends RuntimeException {
	String str;
	public InvalidAgeException(String str) {
		
		super(str);
		this.str = str;
	}
}
