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
	
	static {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","Dhanu@013");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Statement st= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

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
		
		
		String sql="insert into account_details(account_number,acc_holder_name,balance,branch,age,address) values (acc.accountNumber,name,0,branchName,age,address)";
		
		System.out.println("Account Created succesfully");
		
		System.out.println("Your account number is : ");
		System.out.println(acc.accountNumber);
		
		
	}
	
	public void logIn() {
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
			Main.c=1;
		}
	}
	
	
	
	public void deposit() {
		
		System.out.println("Enter the amount for deposit : ");
		int amount = sc.nextInt();
		Functions.balance+=amount;
		Main.accDetails.get(Functions.accoutNumber).balance+=amount;
		
		
	}
	
	
	public void withDraw() {
		System.out.println("Enter the amount for withdraw : ");
		int amount = sc.nextInt();
		if(Functions.balance-amount<0) {
			System.out.println("Not Enough amount");
		}
		else {
		Functions.balance-=amount;
		Main.accDetails.get(Functions.accoutNumber).balance-=amount;
		}
	}
	
	
	public void checkBalance() {
		
		System.out.println(Main.accDetails.get(Functions.accoutNumber).name);
		System.out.println("Account balance : "+Functions.balance);
	}
	
	public void tranferAmount() {
		int amount=sc.nextInt();
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
	public void logOut() {
		Functions.accoutNumber=0;
		Functions.balance=0;
		Functions.name=null;
		System.out.println("Log out Successful");
	}
	
}
