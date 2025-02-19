package RailwayReservation;

import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;

public class Functions {
	
	String name=null;
	
	//data structure delaration
	
	static HashMap <String,Passenger> data= new HashMap<>();
	
	
	Scanner sc= new Scanner(System.in);
	
	//create account
	
	void createAccount() {
		
		Random rand = new Random();
		
		System.out.println("Enter username : ");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		System.out.println("ENter age");
		int age=sc.nextInt();
		System.out.println("Enter gender");
		String gender=sc.next();
		
		int sessionCode=rand.nextInt(1,100);
		
		Passenger passenger= new Passenger(username,password,age,gender,sessionCode);
		
		data.put(username, passenger);
		System.out.println("Account created successfully...");
		
		int c=0;
		System.out.println("want to login press 1");
		c=sc.nextInt();
		
		
		if(c==1)
		this.logIn();
		
		
	}
	
	// login function
	
	void logIn() {
		System.out.println("Enter user name");
		String username=sc.next();
		if(data.containsKey(username)) {
			
			System.out.println("Enter password");
			String pass=sc.next();
			System.out.println(data.get(username).name);
			
			if((data.get(username).password).equals(pass)) {
				System.out.println("Login successful!!");
				Main.session=data.get(username).sessionCode;
				this.name=username;
				
			}
			else {
				System.out.println("Wrong password");
			}
		}
		else {
			System.out.println("Invalid user name");
		}
		
	}
	
	//book ticket
	void bookTicket() {
		System.out.println("Logged in as : "+name);
		System.out.println("Session id : "+Main.session);
		
		System.out.println("Enter name of the passenger");
		
		String passengerName=sc.next();
		
		System.out.println("Enter age  of the passenger");
		
		int passengerAge=sc.nextInt();
		
		System.out.println("Enter preference");
		
		String pref=sc.next();
		
		Booking book = new Booking();
		
		if(pref.equals("L")) {
			
			book.checkLower(passengerName,Main.session);
		}
		else if(pref.equals("M")) {
			
			book.checkMiddle(passengerName, Main.session);
		}
		else if(pref.equals("U")) {
			
			book.checkUpper(passengerName, Main.session);
		}
		
	}
	
	// cancel ticket
	void cancelTicket() {
		
		System.out.println("Logged in as : "+name);
		System.out.println("Session id : "+Main.session);
		
		CancelTicket cancel = new CancelTicket();
		
		cancel.cancelBooking(Main.session);
		
		
	}
	
	// logout function
	
	void logOut() {
		Main.session=0;
		name=null;
	}
}
