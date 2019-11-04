package com.revature.portal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.model.Creds;
import com.revature.pageobjectmodel.RevForceLogin;
import com.revature.pageobjectmodel.RevForceTimesheet;
import com.revature.pageobjectmodel.RevForceHome;

/**
 * Revature: RevForce Portal
 * Package: Portal
 * RevForcePortal.java
 * Main method
 * Purpose: Uses Selenium to enter credentials into RevForce web pages
 * 
 * @author Neil Gorham
 * @version 1.0.0 10/28/2019
 */

public class RevForcePortal {
	//Private variables
	private static WebDriver driver;
	private RevForceLogin rfl;
	private RevForceHome rfh;
	private RevForceTimesheet rft;
	
	/**
	 * Default Constructor
	 */
	public RevForcePortal() { super(); }
	
	/**
	 * Loaded Constructor
	 * @param creds Creds user credentials
	 */
	public RevForcePortal(Creds creds) {
		setup();
		run(creds);
		teardown();
	}
	
	/**
	 * Set up Selenium WebDriver
	 */
	private void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	/**
	 * Tear down Selenium WebDriver
	 */
	private void teardown() {
		driver.close();
		driver.quit();
	}
	
	/**
	 * Runs automated sequence of completing timesheet
	 */
	private void run(Creds creds) {
		//Login to RevForce
		rfl = new RevForceLogin(driver);
		driver.get(rfl.loginURL);
		if(!(driver.getCurrentUrl().equals(rfl.loginURL))) {
			System.err.println("Cannot find RevForce Login page");
			return;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rfl.loginToRevForce(creds.getUsername(), creds.getPassword());
		if(driver.findElement(By.xpath("//div[@class='error']")) != null) {
			System.err.println("Found error(s) on RevForce Login page");
			return;
		}
		//Instantiate new POM of RevForce Home page
		rfh = new RevForceHome(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Navigate to RevForce Current Timesheet page
		rfh.openCurrentTimesheetRevForce();
		//Instantiate new POM of RevForce Timesheet page
		rft = new RevForceTimesheet(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Fill out and submit Timesheet
		rft.fillOutHoursInTimesheet(creds.getHours());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Logout of RevForce
		rft.logoutOfRevForce();
	}
}
