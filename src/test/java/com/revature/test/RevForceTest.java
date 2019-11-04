package com.revature.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.revature.test.pageobjectmodel.RevForceHome;
import com.revature.test.pageobjectmodel.RevForceLogin;
import com.revature.test.pageobjectmodel.RevForceTimesheet;

/**
 * Revature: RevForce Portal
 * Package: Test
 * RevForceTest.java
 * Test for Selenium Automation
 * Purpose: Tests Automation of Revature Portal timesheet submission
 * 
 * @author Neil Gorham
 * @version 1.0.0 10/28/2019
 */

public class RevForceTest {
	//Constants
	public static WebDriver driver;
	public final String loginURL = "https://rev2.force.com/revature/s/login/";
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(loginURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test(priority=1, enabled=false)
	@Parameters({"username", "password"})
	public void testRevForceLogin(String username, String password) {
		//Instantiate new POM of RevForce Login page
		RevForceLogin rfl = new RevForceLogin(driver);
		assertEquals(driver.getCurrentUrl(), rfl.loginURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertNotNull(rfl.getUsernameBox());
		assertNotNull(rfl.getPasswordBox());
		assertNotNull(rfl.getLoginButton());
		rfl.loginToRevForce(username, password);
	}
	
	@Test(priority=1)
	@Parameters({"badUsername", "badPassword"})
	public void testRevForceLoginInvalid(String badUsername, String badPassword) {
		//Instantiate new POM of RevForce Login page
		RevForceLogin rfl = new RevForceLogin(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertNotNull(rfl.getUsernameBox());
		assertNotNull(rfl.getPasswordBox());
		assertNotNull(rfl.getLoginButton());
		rfl.loginToRevForce(badUsername, badPassword);
		assertNotNull(driver.findElement(By.xpath("//div[@class='error']")));
		
	}
	
	@Test(priority=2)
	public void testRevForceHome() {
		//Instantiate new POM of RevForce Home page
		RevForceHome rfh = new RevForceHome(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertNotNull(rfh.getOpenCurrentTimesheetButton());
        rfh.openCurrentTimesheetRevForce();
	}
	
	@Test(priority=3)
	@Parameters({"hours"})
	public void testRevForceTimesheet(double hours) {
		//Instantiate new POM of RevForce Timesheet page
		RevForceTimesheet rft = new RevForceTimesheet(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertNotNull(rft.getMonHoursBox());
		assertNotNull(rft.getTueHoursBox());
		assertNotNull(rft.getWedHoursBox());
		assertNotNull(rft.getThuHoursBox());
		assertNotNull(rft.getFriHoursBox());
		assertNotNull(rft.getSubmitButton());
		assertNotNull(rft.getTotalHoursSpan());
		rft.fillOutHoursInTimesheet(hours);
	}
	
	@Test(priority=4)
	public void testRevForceLogout() {
		//Instantiate new POM of RevForce Timesheet page
		RevForceTimesheet rft = new RevForceTimesheet(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertNotNull(rft.getProfileNameLink());
		assertNotNull(rft.getLogoutLink());
		rft.logoutOfRevForce();
	}
}
	