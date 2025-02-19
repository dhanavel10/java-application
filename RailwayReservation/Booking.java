package RailwayReservation;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Booking {
	
	static int lowSize=1;
	static int midSize=1;
	static int upSize=1;
	int waitSize=5;
	
	
	static int low=0;
	static int mi=0;
	static int up=0;
	static int wait=0;
	
	static HashMap<String,Integer> lower= new HashMap<>(lowSize);
	static HashMap<String,Integer> mid= new HashMap<>(midSize);
	static HashMap<String,Integer> upper= new HashMap<>(upSize);
	static Queue <QueueData> waiting= new LinkedList<>();
	
	
	// book the ticket in lower berth
	void checkLower(String name,int session) {
		if (low<lowSize) {
			lower.put(name, session);
			low++;
			System.out.println("Confirmed in lower");
		}
		else if(mi<midSize){
			mid.put(name, session);
			mi++;
			System.out.println("lower not available... Confirmed in middle");
		}
		else if(up<upSize){
			upper.put(name, session);
			up++;
			System.out.println("lower not available... Confirmed in upper");
		}
		else {
			if(wait<waitSize) {
				QueueData q= new QueueData(name,session);
				waiting.add(q);
				wait++;
				System.out.println("lower not available... Waiting list");
			}
			else {
				System.out.println("Not Available");
			}
		}
	}
	
	
	// book the ticket in Middle berth
	void checkMiddle(String name,int session) {
		if(mi<midSize){
			mid.put(name, session);
			mi++;
			System.out.println("Confirmed in middle");
		}
		else if (low<lowSize) {
			lower.put(name, session);
			low++;
			System.out.println("Middle not available... Confirmed in lower");
		}
		else if(up<upSize) {
			upper.put(name, session);
			up++;
			System.out.println("Middle not available...Confirmed in upper");
			
		}
		else {
			if(wait<waitSize) {
				QueueData q= new QueueData(name,session);
				waiting.add(q);
				wait++;
				System.out.println("Middle not available...waiting list");
			}
			else {
				System.out.println("Not Available");
			}
		}
		
	}
	
	// book the ticket in upper berth
	void checkUpper(String name,int session) {
		
		if(up<upSize) {
			upper.put(name, session);
			up++;
			System.out.println("Confirmed in upper");
			
		}
		else if (low<lowSize) {
			lower.put(name, session);
			low++;
			System.out.println("upper not available... Confirmed in lower");
		}
		else if(mi<midSize) {
			mid.put(name, session);
			mi++;
			System.out.println("upper not available... Confirmed in middle");
		}
		else {
			if(wait<waitSize) {
				QueueData q= new QueueData(name,session);
				waiting.add(q);
				wait++;
				System.out.println("upper not available...Waiting list");
			}
			else {
				System.out.println("Not Available");
			}
		}
	}
	
	//display all the seating
	void displayAll() {
		lower.forEach((key,value)->{
			System.out.println("Lower seating : ");
			System.out.println("Lower : "+key+" "+value);
		});
		
		mid.forEach((key,value)->{
			System.out.println("Middle seating : ");
			System.out.println("Middle : "+key+" "+value);
		});
		upper.forEach((key,value)->{
			System.out.println("Upper seating : ");
			System.out.println("Upper : "+key+" "+value);
		});
	}
	
	
}
