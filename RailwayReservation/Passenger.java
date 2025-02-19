package RailwayReservation;

public class Passenger {
	
	String name;
	int age;
	String gender;
	String password;
	int sessionCode;
	public Passenger(String name,String password, int age, String gender,int sessionCode) {
		super();
		this.name = name;
		this.password=password;
		this.age = age;
		this.gender = gender;
		this.sessionCode=sessionCode;
	}
	
}
