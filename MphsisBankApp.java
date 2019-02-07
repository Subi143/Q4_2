package com.assignment.Q4_2;

import java.util.Scanner;

public class MphsisBankApp {
	static float age;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" WELCOME TO MPHASIS BANK \n----------------------");
		System.out.println("1.SB Account Creation \n2.Current Account Creation \n3.Exit");
		System.out.print("\nEnter Choice: ");
		int option = sc.nextInt();
		if(option == 1) {
			System.out.print("\nEnter Account Number: ");
			long acc_num = sc.nextLong();
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			sc.nextLine();
			try {
				System.out.print("Enter Age: ");
				age = sc.nextFloat();
				if(age < 15) {
					throw new InvalidAgeException("You Must Greater Than 15");
				}
			} catch (InvalidAgeException ie) {
				System.out.println(ie.getMessage());
				System.exit(0);
			}
			System.out.print("Enter Balance: ");
			double balance = sc.nextDouble();
			Account account = new SavingAccount(name, age, acc_num, balance);
			System.out.println("\nSaving Account Created");
			System.out.println("\n    MENU \n  --------");
			System.out.println("1.Deposit \n2.Withdraw \n3.Balance \n4.Logout");
			int choice = sc.nextInt();
			try {
				switch(choice) { 
				
				case 1: 
							System.out.print("Enter Deposit Amount: ");
							double bal = account.deposit(sc.nextDouble());
							System.out.print("\nBalance After Deposit: "+bal);
							break;
				
				case 2: 
							System.out.print("Enter Account Number: ");
							int accno = sc.nextInt();
							if (accno == acc_num) {
								System.out.print("Enter Withdraw Amount: ");
								double bal1 = account.withDraw(sc.nextDouble());
								System.out.print("\nBalance After Withdraw: "+bal1);
								break;
							} else {
							System.out.println("Invalid Account Number......");
							}
						
							break;
				
				case 3: System.out.print("\nAvailable Balance: "+balance);
						break;
						
				case 4: System.out.print("\nThank You....");
						break;
						
				default: System.out.println("Invalid Choice");
						 System.exit(0);
				}
			} catch(InvalidAmountException e) {
				System.out.println(e.getMessage());
			}	
		} else if (option == 2) {
			System.out.print("\nEnter Account Number: ");
			long acc_num = sc.nextLong();
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.print("Enter Age: ");
			float age = sc.nextFloat();
			System.out.print("Enter Balance: ");
			double balance = sc.nextDouble();
			Account account = new CurrentAccount(name, age, acc_num, balance);
			System.out.println("\nCurrent Account Created");
		
			System.out.println("\n    MENU \n  --------");
			System.out.println("1.Deposit \n2.Withdraw \n3.Balance \n4.Logout");
			int choice = sc.nextInt();
			try {
				switch(choice) { 
				case 1: System.out.print("Enter Deposit Amount: ");
						double bal = account.deposit(sc.nextDouble());
						System.out.print("\nBalance After Deposit: "+bal);
						break;
					
				case 2: System.out.print("Enter Account Number: ");
						int accno = sc.nextInt();
						if (accno == acc_num) {
							System.out.print("Enter Withdraw Amount: ");
							double wdamount = sc.nextDouble();
							boolean rs = account.withdraw(wdamount);
							if(rs) {
								CurrentAccount ca = new CurrentAccount(name, age, acc_num, balance);
								double withdrawCal = ca.withdrawCal(wdamount);
								System.out.print("\nBalance After Withdraw: "+withdrawCal);
								break;
							} else {
								System.out.print("\nRequested Amount Could Not Dispense At This Time....");
							}
						} else {
							System.out.println("Invalid Account Number......");
						}
						break;
				
				case 3: System.out.print("\nAvailable Balance: "+balance);
						break;
						
				case 4: System.out.print("\nThank You....");
						break;
						
				default: System.out.println("Invalid Choice");
						 System.exit(0);
			}
			} catch (InvalidAmountException e) {
				e.printStackTrace();
			}
			} else if (option == 3) {
				System.out.println("Thank You...");
			} else {
				System.out.println("Invalid Option.....");
				System.exit(0);
			}
	}
}