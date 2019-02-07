package com.assignment.Q4_2;

public class InvalidAmountException extends RuntimeException {

	String str;
	public InvalidAmountException(String str) {
		
		super(str);
		this.str = str;
	}
}
