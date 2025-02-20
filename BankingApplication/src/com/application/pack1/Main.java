package com.application.pack1;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	int c=0;
	
	public static void main(String []args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Functions functions= new Functions();
		
		//user input functionality
		
		while(true) {
			System.out.println("Enter Choice : ");
			System.out.println("1.Create account \n2.login \n3.Deposit \n4.Withdraw \n5.Check Balance \n6.Transfer \n7.Logout \n8.exit");
			int choice=sc.nextInt();
			
		switch(choice) {
		case 1:
			functions.createAccount();
			
			System.out.println("Log in your account");
			System.out.println("1 to continue and 0 to exit");
			c=sc.nextInt();
			if(c==1) {
				functions.logIn();
			}
			break;
			
		case 2:
			functions.logIn();
			break;
		case 3:
			if(c==1) {
			functions.deposit();
			System.out.println("Deposit succesfull");
			}
			break;
			
		case 4:
			if(c==1) {
				functions.withDraw();
			}
			break;
		case 5:
			if(c==1) {
				functions.checkBalance();
			}
			break;
			
		case 6:
			if(c==1) {
				functions.tranferAmount();
			}
			break;
			
		case 7:
			if(c==1) {
				functions.logOut();
				c=0;
			}
			break;
		case 8:
			System.out.println("Process end");
			System.exit(0);
		}
		}
		
	}
}
