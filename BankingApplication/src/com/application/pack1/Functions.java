package com.application.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Functions {
	Scanner sc= new Scanner(System.in);
	static String name;
	static long accoutNumber;
	static long balance;
	
	HashMap<Long,Account> accDetails= new HashMap<>();
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
		accDetails.put(acc.accountNumber, acc);
		
		
		System.out.println("Account Created succesfully");
		
		System.out.println("Your account number is : ");
		System.out.println(acc.accountNumber);
		
		
	}
	
	//login function
	
	public void logIn() {
		System.out.println("Enter account number");
		long number= sc.nextLong();
		if(!accDetails.containsKey(number)) {
			System.out.println("Invalid number");
		}
		else {
			System.out.println("Welcome "+accDetails.get(number).name);
			Functions.name=accDetails.get(number).name;
			Functions.balance=accDetails.get(number).balance;
			Functions.accoutNumber=accDetails.get(number).accountNumber;
			Main.c=1;
		}
	}
	
	//deposit function
	
	public void deposit() {
		
		System.out.println("Enter the amount for deposit : ");
		int amount = sc.nextInt();
		Functions.balance+=amount;
		accDetails.get(Functions.accoutNumber).balance+=amount;
		
		
	}
	
	//withdraw
	
	public void withDraw() {
		System.out.println("Enter the amount for withdraw : ");
		int amount = sc.nextInt();
		if(Functions.balance-amount<0) {
			System.out.println("Not Enough amount");
		}
		else {
		Functions.balance-=amount;
		accDetails.get(Functions.accoutNumber).balance-=amount;
		}
	}
	
	// check balance
	
	public void checkBalance() {
		
		System.out.println(accDetails.get(Functions.accoutNumber).name);
		System.out.println("Account balance : "+Functions.balance);
	}
	//tranfer amount
	
	public void tranferAmount() {
		int amount=sc.nextInt();
		long accountNumber=sc.nextLong();
		
		if(Functions.balance<amount) {
			System.out.println("Not Enough amount");
		}
		else {
		
		if(accDetails.containsKey(accountNumber)) {
			accDetails.get(accountNumber).balance+=amount;
			System.out.println("Transfer Success");
			Functions.balance-=amount;
			accDetails.get(Functions.accoutNumber).balance-=amount;
		}
		else {
			System.out.println("Account number not available!");
		}
		
		}
	}
	
	//logout function
	public void logOut() {
		Functions.accoutNumber=0;
		Functions.balance=0;
		Functions.name=null;
		System.out.println("Log out Successful");
	}
	
}
