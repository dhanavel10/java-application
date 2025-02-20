package com.application.pack1;

import java.util.Scanner;

public class Functions {
	Scanner sc= new Scanner(System.in);
	static String name;
	static long accoutNumber;
	static double balance;
	
	
	//create account

	public void createAccount() {
		
		
		System.out.println("Enter details : ");
		System.out.println("name : ");
		String name=sc.next();
		System.out.println("age : ");
		int age=sc.nextInt();
		System.out.println("address : ");
		String address=sc.next();
		System.out.println("branch name : ");
		String branchName=sc.next();
		Account acc= new Account(name,age,address,branchName);
		Main.accDetails.put(acc.accountNumber, acc);
		
		
		System.out.println("Account Created succesfully");
		
		System.out.println("Your account number is : ");
		System.out.println(acc.accountNumber);
		
		
	}
	
	//login function
	
	public boolean logIn() {
		System.out.println("Enter account number");
		long number= sc.nextLong();
		if(!Main.accDetails.containsKey(number)) {
			System.out.println("Invalid number");
		}
		else {
			System.out.println("Welcome "+Main.accDetails.get(number).name);
			Functions.name=Main.accDetails.get(number).name;
			Functions.balance=Main.accDetails.get(number).balance;
			Functions.accoutNumber=Main.accDetails.get(number).accountNumber;
			return true;
		}
		return false;
	}
	
	//deposit function
	
	public void deposit() {
		
		System.out.println("Enter the amount for deposit : ");
		double amount = sc.nextDouble();
		Functions.balance+=amount;
		Main.accDetails.get(Functions.accoutNumber).balance+=amount;
		
		
	}
	
	//withdraw
	
	public void withDraw() {
		System.out.println("Enter the amount for withdraw : ");
		double amount = sc.nextDouble();
		if(Functions.balance-amount<0) {
			System.out.println("Not Enough amount");
		}
		else {
		Functions.balance-=amount;
		Main.accDetails.get(Functions.accoutNumber).balance-=amount;
		}
	}
	
	// check balance
	
	public void checkBalance() {
		
		System.out.println(Main.accDetails.get(Functions.accoutNumber).name);
		System.out.println("Account balance : "+Functions.balance);
	}
	//tranfer amount
	
	public void tranferAmount() {
		double amount=sc.nextDouble();
		long accountNumber=sc.nextLong();
		
		if(Functions.balance<amount) {
			System.out.println("Not Enough amount");
		}
		else {
		
		if(Main.accDetails.containsKey(accountNumber)) {
			Main.accDetails.get(accountNumber).balance+=amount;
			System.out.println("Transfer Success");
			Functions.balance-=amount;
			Main.accDetails.get(Functions.accoutNumber).balance-=amount;
		}
		else {
			System.out.println("Account number not available!");
		}
		
		}
	}
	
	//logout function
	public boolean logOut() {
		Functions.accoutNumber=0;
		Functions.balance=0;
		Functions.name=null;
		System.out.println("Log out Successful");
		
		return false;
	}
	
}
