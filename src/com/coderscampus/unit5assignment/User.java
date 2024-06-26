package com.coderscampus.unit5assignment;

//This is a POJO (Plain Old Java Object)
public class User {
	
	//instance variables (declared as private)
	private String username;
	private String password;
	private String name;
	
	//getters and setters for the above instance variables
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static int loginAttemptsBeforeLock = 5;
		
}