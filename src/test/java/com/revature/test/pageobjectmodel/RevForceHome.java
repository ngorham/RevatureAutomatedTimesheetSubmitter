package com.revature.test.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Revature: RevForce Portal
 * Package: PageObjectModel
 * RevForceHome.java
 * Page Object Model for Selenium Automation
 * Purpose: Storage and access of RevForce Home page elements
 * 
 * @author Neil Gorham
 * @version 1.0.0 10/20/2019
 */

public class RevForceHome {
	//Public Constants
	public final String homeURL = "https://rev2.force.com/revature/s/";
	//Private variables
	@FindBy(xpath="//button[@title='Open Current Timesheet']")
	private WebElement openCurrentTimesheetButton;
	@FindBy(xpath="//*[@id=\"3:54;a\"]/div/div/a")
	private WebElement profileNameLink;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	/**
	 * Loaded Constructor
	 * 
	 *  @param driver WebDriver
	 */
	public RevForceHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Interactive Methods
	/**
	 * Navigate to the RevForce Current Timesheet page
	 */
	public void openCurrentTimesheetRevForce() {
		//Click to simulate clicking button to navigate to Current Timesheet
		//page
		this.openCurrentTimesheetButton.click();
	}
	
	/**
	 * Logout of RevForce by clicking the logout link
	 */
	public void logoutOfRevForce() {
		//Click to simulate clicking profile name link to trigger pop up list
		this.profileNameLink.click();
		//Click to simulate clicking the logout link
		this.logoutLink.click();
	}
	
	//Getter Methods
	/**
	 * Get openCurrentTimesheetButton WebElement
	 * 
	 * @return openCurrentTimesheetButton WebElement openCurrentTimesheetButton
	 * HTML button element
	 */
	public WebElement getOpenCurrentTimesheetButton() {
		return openCurrentTimesheetButton;
	}	
	
	/**
	 * Get logoutLink WebElement
	 * 
	 * @return logoutLink WebElement logoutLink HTML anchor element
	 */
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	/**
	 * Get profileNameLink WebElement
	 * 
	 * @return profileNameLink WebElement profileNameLink HTML anchor element
	 */
	public WebElement getProfileNameLink() {
		return profileNameLink;
	}
}
