package com.revature.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Revature: RevForce Portal
 * Package: PageObjectModel
 * RevForceTimesheet.java
 * Page Object Model for Selenium Automation
 * Purpose: Storage and access of RevForce Timesheet page elements
 * 
 * @author Neil Gorham
 * @version 1.0.0 10/20/2019
 */

public class RevForceTimesheet {
	//Public constants
	public final String timesheetURL = "https://rev2.force.com/revature/s/timesheet";
	//Private variables
	@FindBy(xpath="//*[@id=\"80:179;a\"]")
	private WebElement monHoursBox;
	@FindBy(xpath="//*[@id=\"92:179;a\"]")
	private WebElement tueHoursBox;
	@FindBy(xpath="//*[@id=\"104:179;a\"]")
	private WebElement wedHoursBox;
	@FindBy(xpath="//*[@id=\"116:179;a\"]")
	private WebElement thuHoursBox;
	@FindBy(xpath="//*[@id=\"128:179;a\"]")
	private WebElement friHoursBox;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//*[@id=\"table\"]/tbody/tr[1]/td[9]/span")
	private WebElement totalHoursSpan;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath="//*[@id='CustomerPortalTemplate']/div[2]/div/div[2]/div/div/div/div[2]/div/div[2]/table")
	private WebElement timesheetTable;
	@FindBy(xpath="//*[@id=\"3:54;a\"]/div/div/a")
	private WebElement profileNameLink;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	/**
	 * Loaded Constructor
	 * 
	 * @param driver WebDriver 
	 */
	public RevForceTimesheet(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Interactive Methods
	/**
	 * Enter the numbers of hours worked in each weekday HTML input element
	 * 
	 * @param hours String number of hours to enter in each HTML input element
	 */
	public void fillOutHoursInTimesheet(double hours) {
		String hoursStr = Double.toString(hours);
		//Enter hours into each input element
		this.monHoursBox.clear();
		this.monHoursBox.sendKeys(hoursStr);
		this.tueHoursBox.clear();
		this.tueHoursBox.sendKeys(hoursStr);
		this.wedHoursBox.clear();
		this.wedHoursBox.sendKeys(hoursStr);
		this.thuHoursBox.clear();
		this.thuHoursBox.sendKeys(hoursStr);
		this.friHoursBox.clear();
		this.friHoursBox.sendKeys(hoursStr);
		//Check if total hours is (hours * 5)
		Double totalHours = Double.parseDouble(this.totalHoursSpan.getText());
		if(totalHours == (hours * 5)) {
			//this.submitButton.click();
			System.out.println("submit button clicked");
		}
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

	//Getters Methods
	/**
	 * Get the monHoursBox WebElement 
	 * 
	 * @return monHoursBox WebElement Monday hours HTML input element
	 */
	public WebElement getMonHoursBox() {
		return monHoursBox;
	}

	/**
	 * Get the tueHoursBox WebElement
	 * 
	 * @return tueHoursBox WebElement Tuesday hours HTML input element
	 */
	public WebElement getTueHoursBox() {
		return tueHoursBox;
	}

	/**
	 * Get the wedHoursBox WebElement
	 * 
	 * @return wedHoursBox WebElement Wednesday hours HTML input element
	 */
	public WebElement getWedHoursBox() {
		return wedHoursBox;
	}

	/**
	 * Get the thuHoursBox WebElement
	 * 
	 * @return thuHoursBox WebElement Thursday hours HTML input element
	 */
	public WebElement getThuHoursBox() {
		return thuHoursBox;
	}

	/**
	 * Get the friHoursBox WebElement
	 * 
	 * @return friHoursBox WebElement Friday hours HTML input element
	 */
	public WebElement getFriHoursBox() {
		return friHoursBox;
	}

	/**
	 * Get the submitButton WebElement
	 * 
	 * @return submitButton WebElement submitButton HTML button element
	 */
	public WebElement getSubmitButton() {
		return submitButton;
	}

	/**
	 * Get the totalHoursSpan WebElement
	 * 
	 * @return totalHoursSpan WebElement totalsHoursSpan HTML span element
	 */
	public WebElement getTotalHoursSpan() {
		return totalHoursSpan;
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
	 * Get saveButton WebElement
	 * 
	 * @return saveButton WebElement saveButton HTML button element
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * Get the timesheetTable WebElement
	 * 
	 * @return timesheetTable WebElement timesheetTable HTML table element
	 */
	public WebElement getTimesheetTable() {
		return timesheetTable;
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
