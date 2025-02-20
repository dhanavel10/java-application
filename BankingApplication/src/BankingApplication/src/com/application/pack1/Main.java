package com.application.pack1;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Functions functions = new Functions();

		// user input functionality
		
		while(true) {
			System.out.println("1.Login");
			System.out.println("2.Create account");
			System.out.println("3.exit");
			int choice=sc.nextInt();
		
			boolean flag = true;
		
			switch(choice) {
			case 1:
				
				if(functions.logIn()) {
					
					while(flag) {
						System.out.println("Enter the choice : ");
						System.out.println("Deposit Withdraw check balance transfer logout");
						int ch= sc.nextInt();
						
						switch(ch) {
						
						case 1:
							
							functions.deposit();
							break;
						case 2:
							functions.withDraw();
							break;
						
						case 3:
							functions.checkBalance();
							break;
						
						case 4:
							functions.tranferAmount();
							break;
							
						case 5:
							functions.logOut();
							flag=false;
							break;
						}
						
					}
				
				}
			case 2:
				functions.createAccount();
				break;
			case 3:
				System.exit(0);
			}

		
	}
		
	}
}
