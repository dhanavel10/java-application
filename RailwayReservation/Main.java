package RailwayReservation;

import java.util.Scanner;

public class Main {
	static int session =0;

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		Functions function= new Functions();
		
		Booking book = new Booking();
		
		while(true) {
		
		System.out.println("Enter choice : ");
		System.out.println("1.Create account");
		System.out.println("2.Login");
		System.out.println("3.Book tickets");
		System.out.println("4.Cancel ticket");
		System.out.println("5.Logout");
		System.out.println("6.exit");
		System.out.println("7.Display all ticket");
//		
		int choice=sc.nextInt();
		
		
		// user choice getting
		switch(choice) {
		case 1:
			System.out.println("create account");
			function.createAccount();
			break;
		
		case 2:
			System.out.println("Log in");
			function.logIn();
			break;
			
		case 3:
			if(session>0) {
			System.out.println("Book ticket");
			function.bookTicket();
			}
			break;
			
		case 4:
			if(session>0) {
			System.out.println("Cancel ticket");
			function.cancelTicket();
			}
			break;
			
		case 5:
			if(session>0) {
				function.logOut();
			}
			break;
		case 6:
			System.exit(0);
		}
		
		

	}
	}

}
