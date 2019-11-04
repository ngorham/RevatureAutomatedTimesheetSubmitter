package com.revature.util;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Creds;

/**
 * Revature: RevForce Portal
 * Package: Util
 * Utilities.java
 * Utilities
 * Purpose: Storage for static variables and methods commonly used in the app
 * 
 * @author Neil Gorham
 * @version 1.0.0 11/03/2019
 */

public class Utilities {
	//Private variables
	//Private constants
	//Public constants
	
	/**
	 * Parse XML file to Creds object
	 * 
	 * @param fileName String fileName of an xml file
	 * @return creds Creds object with credentials
	 */
	public static Creds xmlFileToCreds(String fileName) {
		Creds creds = null;
		try {
			File xmlData = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Creds.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			creds = (Creds) jaxbUnmarshaller.unmarshal(xmlData);
		} catch(JAXBException e) {
			e.printStackTrace();
			System.err.println(fileName + ": Error reading form file!");
		}
		return creds;
	}
	
	/**
	 * Parse JSON file to Creds object
	 * 
	 * @param fileName String fileName of a json file
	 * @return creds Creds object with credentials
	 */
	public static Creds jsonFileToCreds(String fileName) {
		Creds creds = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File jsonData = new File(fileName);
			creds = mapper.readValue(jsonData, Creds.class);
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println(fileName + ": Error reading form file!");
		}
		return creds;
	}
	
	public static Creds credsPrompt() {
		Creds creds = null;
		Scanner in = new Scanner(System.in);
		String username = "";
		String password = "";
		//double hours = 0.0;
		boolean validUsername = false;
		boolean validPassword = false;
		//boolean validHours = false;
		System.out.println("Enter in user credentials");
		while(!validUsername) {
			System.out.print("Username: ");
			username = in.nextLine();
			//process input
			if(username.matches("^.*\\..*@revature.portal$")) {
				//valid input
				validUsername = true;
			} else {
				//invalid input
				System.out.println(username + " not valid, re-enter");
			}
		}
		while(!validPassword) {
			System.out.print("password: ");
			password = in.nextLine();
			validPassword = true;
		}
		/*while(!validHours) {
			try {
				System.out.print("hours: ");
				hours = in.nextDouble();
				validHours = true;
			} catch(InputMismatchException e) {
				System.out.println("Error - not a number, re-enter");
				in.next();
			}
		}*/
		in.close();
		creds = new Creds(username, password);
		return creds;
	}
}
