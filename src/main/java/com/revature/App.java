package com.revature;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Creds;

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
				try {
					File xmlData = new File(fileName);
					JAXBContext jaxbContext = JAXBContext.newInstance(Creds.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					creds = (Creds) jaxbUnmarshaller.unmarshal(xmlData);
					System.out.println(creds.toString());
				} catch(JAXBException e) {
					e.printStackTrace();
					System.err.println(fileName + ": Error reading form file!");
				}
			} else if(fileName.matches("^.*\\.json$") || fileName.matches("^.*\\.JSON$")) {
				//Parse JSON file
				System.out.println("json file: " + fileName);
				try {
					ObjectMapper mapper = new ObjectMapper();
					File jsonData = new File(fileName);
					creds = mapper.readValue(jsonData, Creds.class);
					System.out.println(creds.toString());
				} catch(IOException e) {
					e.printStackTrace();
					System.err.println(fileName + ": Error reading form file!");
				}
			} else { //Not xml or json formatted file
				System.out.println("file name: " + fileName);
			}
			//System.out.println(fileName);
		} else { //prompt user for credentials
			System.out.println("no args");
		}
	}

}
