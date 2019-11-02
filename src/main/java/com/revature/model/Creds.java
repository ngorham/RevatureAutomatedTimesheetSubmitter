package com.revature.model;

/**
 * Revature: RevForce Portal
 * Package: Model
 * Creds.java
 * Java Bean Model
 * Purpose: Storage and access of credentials
 * 
 * @author Neil Gorham
 * @version 1.0.0 11/02/2019
 */

public class Creds {
	//Private variables
	private String username;
	private String password;
	private double hours = 0.0;
	
	/**
	 * Default Constructor
	 */
	public Creds() { super(); }

	/**
	 * Loaded Constructor 
	 * 
	 * @param username String username to be entered
	 * @param password String password to be entered
	 * @param hours double hours to be entered
	 */
	public Creds(String username, String password, double hours) {
		super();
		this.username = username;
		this.password = password;
		this.hours = hours;
	}

	/**
	 * Get the username
	 * 
	 * @return username String username to be entered
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username
	 * 
	 * @param username String username to be entered
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the password
	 * 
	 * @return password String password to be entered
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password
	 * 
	 * @param password String password to be entered
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the hours
	 * 
	 * @return hours double hours to be entered
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * Set the hours
	 * 
	 * @param hours double hours to be entered
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}

	/**
	 * Generates a unique hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(hours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * Compares this object with another
	 * 
	 * @param obj Object object to be compared
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Creds other = (Creds) obj;
		if (Double.doubleToLongBits(hours) != Double.doubleToLongBits(other.hours))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	/**
	 * String representation of the Creds
	 * 
	 * @return String representation of the Creds
	 */
	@Override
	public String toString() {
		return "Creds [username=" + username + ", password=" + password + ", hours=" + hours + "]";
	}
}
