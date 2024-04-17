package com.coderscampus.unit5assignment;

import java.io.BufferedReader;
import java.util.Scanner;

public class UserService {

	public static User userLogin (String username, String password) {
		//create new instance of object 
		User userLogin = new User();
		//use setters to set values for attributes of object instance
		userLogin.setUsername(username);
		userLogin.setPassword(password);	 
		//return instance of object
		return userLogin;
	}
	
	
	public static void appUsernamePrompt() {
		System.out.println("---------");
		System.out.println("Username:\n >");		
	}
	
	public static void appPasswordPrompt() {
		System.out.println("---------");
		System.out.println("Password:\n >");		
	}
	
	public static void appInput() {
		//create instance of new scanner object
		Scanner inputScanner = new Scanner(System.in);
		//show prompt for user's input, assign value to variables
		appUsernamePrompt();
		String usernameInput = inputScanner.nextLine();				
		appPasswordPrompt();
		String passwordInput = inputScanner.nextLine();
		//close scanner, pass the input into other method for validation
		inputScanner.close();
		appInputCheck(usernameInput, passwordInput);
	}
	
	public static void appInputCheck(String username, String password) {
		//initialize objects
		User[] realUsers = null;
		BufferedReader fileReader = null;

		//read data from data.txt
		//insert it into an array
		//check user input against array


			
			
		
	}

}