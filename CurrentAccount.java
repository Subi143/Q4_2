package com.assignment.Q4_2;

public class CurrentAccount extends Account {
	
	private double balance;
	private double overDraftLimit = -5000;
	
	public CurrentAccount(String name, float age, long accNum, double balance) {
		
		super(name, age, accNum);
		this.balance = balance;
	}

	@Override
	public double deposit(double amount) throws InvalidAmountException {
		
		if (amount <= 0)
			throw new InvalidAmountException("Can't Deposit Zero.....");
		else
			balance = balance + amount;
		
		return balance;
	}

	@Override
	public boolean withdraw(double amount) {
		boolean limit = true;
		if((balance-amount) < overDraftLimit)
			limit = false;
		return limit;
	}
	
	public double withdrawCal(double amount) throws InvalidAmountException {
		if (amount <= 0)
			throw new InvalidAmountException("Can't Withdraw Zero.....");
		else {
			balance = balance - amount;
		}
		return balance;
	}

	@Override
	public double withDraw(double amount) {
		return 0;
	}
}
