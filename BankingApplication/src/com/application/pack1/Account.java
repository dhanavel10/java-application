package com.application.pack1;
import java.util.Random;

public class Account {

	long accountNumber;
	String name;
	int age;
	String address;
	String branchName;
	double balance;
	int branchId;
	Random ran= new Random();
	
	Account(String name,int age,String address,String branchName){
		this.name=name;
		this.age=age;
		this.address=address;
		this.branchName=branchName;
		this.accountNumber=ran.nextLong(100000000,999999999);
		
		
	}
	
}


