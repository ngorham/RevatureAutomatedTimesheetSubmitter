package com.revature.util;

import java.io.File;
import java.io.IOException;

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
}
