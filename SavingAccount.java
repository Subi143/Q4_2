package com.assignment.Q4_2;

public class SavingAccount extends Account {
	
	private double balance;
	private final double minBal = 1000;


	public SavingAccount(String name, float age, long accNum, double balance) {
		
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
	public double withDraw(double amount) throws InvalidAmountException {
		if (amount <= 0)
			throw new InvalidAmountException("Can't Withdraw Zero.....");
		else if ((balance-amount) < 1000) {
			System.out.println("Minimum Balance Should Be 1000...");
		} else {
			balance = balance - amount;
		}
		return balance;
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}
	
}
