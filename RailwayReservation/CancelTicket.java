package RailwayReservation;

import java.util.Scanner;

public class CancelTicket {
	
	Scanner sc= new Scanner(System.in);

	
	void cancelBooking(int session) {
		
		Booking book = new Booking();
		
		System.out.println("Enter name of ticket to cancel");
		String ticketName=sc.next();
		
		if(Booking.lower.containsKey(ticketName)) {
			
			if(session==Booking.lower.get(ticketName)) {
				
				Booking.lower.remove(ticketName);
				
				Booking.low--;
				
				System.out.println("Cancelled in lower");
				
				if(Booking.waiting.peek()!=null) {
					
				QueueData q=Booking.waiting.poll();
				
				book.checkLower(q.name, q.session);
				
				}
				else
				System.out.println("No waiting list");
			}
			else {
				System.out.println("Cannot cancel ticket...");
			}
			
		}
		else if(Booking.mid.containsKey(ticketName)) {
			
			if(session==Booking.mid.get(ticketName)) {
				
				Booking.mid.remove(ticketName);
				
				Booking.mi--;
				
				System.out.println("Cancelled in middle");
				
				if(Booking.waiting.peek()!=null) {
					
					QueueData q=Booking.waiting.poll();
					
					book.checkLower(q.name, q.session);
					
					}
					else
					System.out.println("No waiting list");
				
				
				
				
			}
			else {
				System.out.println("Cannot cancel ticket...");
			}
			
		}
		else if(Booking.upper.containsKey(ticketName)) {
			
			if(session==Booking.upper.get(ticketName)) {
				
				Booking.upper.remove(ticketName);
				
				Booking.up--;
				
				System.out.println("Cancelled in upper");
				
				if(Booking.waiting.peek()!=null) {
					
					QueueData q=Booking.waiting.poll();
					
					book.checkLower(q.name, q.session);
					
					}
					else
					System.out.println("No waiting list");
			}
			else {
				System.out.println("Cannot cancel ticket...");
			}
			
		}
		else {
			System.out.println("No ticket ");
		}
	}
}