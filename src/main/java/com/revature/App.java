package com.revature;

/**
 * Revature: RevForce Portal
 * Package: Revature
 * App.java
 * Main method
 * Purpose: Runs Automation Revature Portal Timesheet Submitter
 * 
 * @author Neil Gorham
 * @version 1.0.0 10/28/2019
 */

public class App {

	public static void main(String[] args) {
		
		if(args.length > 1) {
			System.out.println("Incorrect usage");
			System.exit(1);
		} else if(args.length == 1) { //parse file for credentials
			String fileName = args[0];
			System.out.println(fileName);
		} else { //prompt user for credentials
			System.out.println("no args");
		}
	}

}
