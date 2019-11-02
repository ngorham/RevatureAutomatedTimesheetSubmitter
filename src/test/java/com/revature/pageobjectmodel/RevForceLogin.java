package com.revature.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Revature: RevForce Portal
 * Package: PageObjectModel
 * RevForceLogin.java
 * Page Object Model for Selenium Automation
 * Purpose: Storage and access of RevForce Login page elements
 * 
 * @author Neil Gorham
 * @version 1.0.0 10/20/2019
 */

public class RevForceLogin {
	//Public Constants
	public final String loginURL = "https://rev2.force.com/revature/s/login/";
	//Private variables
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement usernameBox;
	@FindBy(xpath="//input[@placeholder='Password']")
	private  WebElement passwordBox;
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginButton;
	@FindBy(xpath="//*[@id=\"3:54;a\"]/div/div/a")
	private WebElement profileNameLink;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	/**
	 * Loaded Constructor
	 * 
	 * @param driver WebDriver 
	 */
	public RevForceLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Interactive Methods
	/**
	 * Login into RevForce with username and password by entering Strings into
	 * to the respective WebElements then clicking the login button
	 * 
	 * @param username String username to be entered in usernameBox 
	 * @param password String password to be entered in passwordBox
	 */
	public void loginToRevForce(String username, String password) {
		//Send keys to simulate entering in credentials to login
		this.usernameBox.sendKeys(username);
		this.passwordBox.sendKeys(password);
		//Click to simulate clicking button to navigate to Home page
		this.loginButton.click();
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
	 * Get the usernameBox WebElement
	 * 
	 * @return usernameBox WebElement usernameBox HTML input element
	 */
	public WebElement getUsernameBox() {
		return usernameBox;
	}

	/**
	 * Get passwordBox WebElement
	 * 
	 * @return password WebElement passwordBox HTML input elements
	 */
	public WebElement getPasswordBox() {
		return passwordBox;
	}

	/**
	 * Get loginButton WebElement
	 * 
	 * @return loginButton WebElement loginButton HTML button element
	 */
	public WebElement getLoginButton() {
		return loginButton;
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
	 * Get the loginURL String
	 * 
	 * @return loginURL String URL of the RevForce login page
	 */
	public String getLoginURL() {
		return loginURL;
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
