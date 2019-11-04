package com.revature;

import com.revature.model.Creds;
import com.revature.util.Utilities;

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
		Creds creds = null;
		if(args.length > 1) {
			System.out.println("Incorrect usage");
			System.exit(1);
		} else if(args.length == 1) { //parse file for credentials
			String fileName = args[0];
			if(fileName.matches("^.*\\.xml$") || fileName.matches("^.*\\.XML$")) {
				//Parse XML file
				System.out.println("xml file: " + fileName);
				creds = Utilities.xmlFileToCreds(fileName);
				System.out.println(creds.toString());
			} else if(fileName.matches("^.*\\.json$") || fileName.matches("^.*\\.JSON$")) {
				//Parse JSON file
				System.out.println("json file: " + fileName);
				creds = Utilities.jsonFileToCreds(fileName);
				System.out.println(creds.toString());
			} else { //Not xml or json formatted file
				System.out.println("File format not recognized. Accepted file format: *.xml or *.json"
						+ "\nfile name: " + fileName
						+ "\nClosing app...");
				System.exit(0);
			}
			//Pass creds into RevForcePortal object
		} else { //prompt user for credentials
			creds = Utilities.credsPrompt();
			System.out.println(creds.toString());
		}
	}
}
