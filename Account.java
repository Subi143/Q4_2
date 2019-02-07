package com.assignment.Q4_2;

public abstract class Account {
	
	private String name;
	private float age;
	long accNum;

	public Account(String name, float age, long accNum) {
		super();
		this.name = name;
		this.age = age;
		this.accNum = accNum;
	}
	
	public abstract double deposit(double amount);
	public abstract boolean withdraw(double amount);
	public abstract double withDraw(double amount);
}
