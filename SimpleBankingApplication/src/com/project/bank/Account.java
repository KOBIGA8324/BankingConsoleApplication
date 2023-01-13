package com.project.bank;

import java.util.Scanner;

public class Account {

	int balance;
	int previousTransaction;
	String customerName;
	String customerID;


	public Account(String cName, String cID) {
		this.customerName=cName;
		this.customerID=cID;

	}
	void login(String username, String password) {

		if(username.equals("Niru")&& password.equals("hello8324")) {
			System.out.println("\u001B[32mSuccess\u001B[0m");
		}else {
			System.out.println("\u001B[31mFailed\u001B[0m");
			System.exit(0);

		}//\033[1mSAMPATH BANK\033[0m


	}


	void deposit(int amount) {
		if(amount!=0) {
			balance=balance+amount;
			previousTransaction=amount;
		}
	}

	void withdraw(int amount) {
		if(amount!=0) {
			balance= balance-amount;
			previousTransaction= -amount;
		}

	}
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Deposited: " +previousTransaction);
		}else if(previousTransaction<0) {
			System.out.println("Withdraw: "+ Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction occured");
		}
	}
	void calculateInterest(int year) {
		double interestRate=0.185;
		double newBalance=(balance*interestRate*year)+balance;
		System.out.println("The current interest rate is: " +(100*interestRate)+"%");
		System.out.println("After "+ year+ " years , Your balance will be : " +newBalance);

	}
	void showMenu() {
		char option;
		Scanner scan= new Scanner(System.in);
		System.out.printf("%50s\n","\u001B[1;33mSAMPATH BANK\u001B[0m");
		System.out.println("Username: ");
		System.out.println("Password: ");
		String _name=scan.next();
		String _pw=scan.next();
		System.out.println();
		login(_name,_pw);
		System.out.println();
		System.out.println("Welcome "+ customerName+ "!");
		System.out.println("Account ID: "+customerID);
		System.out.println();

		System.out.printf("\033[1mWhat would you like to do?\033[0m").println();
		System.out.println();
		System.out.println("A.Check you balance");
		System.out.println("B.Make a deposite");
		System.out.println("C.Make a withdraw");
		System.out.println("D.View previous transaction");
		System.out.println("E.Calculate interest");
		System.out.println("F.Exit");

		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1=scan.next().charAt(0);
			option=Character.toUpperCase(option1);
			System.out.println();

			switch(option) {
			case 'A':
				System.out.println("================================================ ");
				System.out.println("Balance = LKR "+ balance);
				System.out.println("================================================ ");

				break;
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount1=scan.nextInt();
				deposit(amount1);
				System.out.println();
				break;
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2=scan.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case 'D':
				System.out.println("================================================ ");
				getPreviousTransaction();
				System.out.println("================================================ ");
				System.out.println();
				break;
			case 'E':
				System.out.println("Enter how many year of accured interest: ");
				int year=scan.nextInt();
				calculateInterest(year);
				break;
			case 'F':
				System.out.println("================================================ ");
				break;
			default:
				System.out.printf("\u001B[1;31m"+"Error: invalid option.Please enter A,B,C,D,E"+"\u001B[0m");

				break;

			}


		}while(option!='F');

		System.out.printf("%65s\n","\033[1m "+"Thank You for Banking with us!"+"\033[0m");

		System.exit(0);






	}
}
