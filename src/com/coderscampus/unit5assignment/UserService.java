package com.coderscampus.unit5assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;

public class UserService {
	//========================================================
	public static void appUsernamePrompt() {
		System.out.println("---------");
		System.out.println("Username:\n >");		
	}
	//========================================================
	public static void appPasswordPrompt() {
		System.out.println("---------");
		System.out.println("Password:\n >");		
	}
	//========================================================
	public User createUser (String username, String password, String name) {
		//create new instance of object 
		User newUser = new User();
		//use setters to set values for attributes of object instance
		newUser.setUsername(username);
		newUser.setPassword(password);	 
		newUser.setName(name);
		//System.out.println("User Created");
		//return instance of object
		return newUser;
	}	
	//========================================================
	public static void appInput() {
		
		//initialize objects
		Scanner inputScanner = new Scanner(System.in);		
		
		//=================BEGIN input from USER====================
		//show prompt for user's input, assign value to variables
		appUsernamePrompt();
		String usernameInput = inputScanner.nextLine();				
		appPasswordPrompt();
		String passwordInput = inputScanner.nextLine();
		//close scanner, pass the input into other method for validation
		
		//================END input from the USER================
		
		appInputCheck(usernameInput, passwordInput);
		inputScanner.close();					
		//somewhere load up an array of users userArray[i] = userService.createUser(null, null, null);		
	}			
	//========================================================
	public static void appInputCheck(String username, String password) {
		//initialize object(s)			
		User realUsers[] = fillUserArray();
		//check user input against array of Users then
		//give feedback against login creds
		int i = 0;
		while (User.loginAttemptsBeforeLock > 1) {
					
		while (i < 4) { //username isn't case sensitive, password is
			if (username.equalsIgnoreCase(realUsers[i].getUsername()) && password == realUsers[i].getPassword()) {
				System.out.println("Welcome: " + realUsers[i].getName());
			} else {
				System.out.println("Invalid login, please try again.");				
				User.loginAttemptsBeforeLock--; //lower login attempts
				System.out.println("You have " + User.loginAttemptsBeforeLock + " attempts remaining");
				appInput(); //return user to login again
			}						
			i++;
		}
		}				
			//yeah, I know this is a little lazy . . . 
		if (User.loginAttemptsBeforeLock == 1 || User.loginAttemptsBeforeLock == 0) {
			lockoutScreen(); 	
			System.exit(0); //force app to terminate
		}					
	}
	//========================================================
	public static void lockoutScreen() {
		
		System.out.println("\n(ㅠ﹏ㅠ)\n_____________________________________________________\n");
		System.out.println("Too many failed login attempts, you are now locked out.");
	}
	//=========================================================
	public static String[] convertFile() throws IOException {
		//create objects
		String[] newArray = new String[12];
		String[] splitArray = new String[12];
		BufferedReader fileReader = null;
		String aLine = "";
		
		int k = 0;
		
		//begin reading the data.txt file, then split, and return
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
							
										 				
				for (int i = 0; i < 4; i++) {
					
					//System.out.println(k); this shows increments of 3 for k, while loop
					//runs up to length of splitArray, which is 3
					//3 * 4 == 12, matching length of newArray
					while ((aLine = fileReader.readLine()) != null) {
				
					splitArray = aLine.split(",");
					int j = 0;
					//add the 3 elements into a newArray from splitArray 
					while (j < splitArray.length && k < newArray.length){
						newArray[k] = splitArray[j];	
						j++;
						k++;
					} 
				}
			}
				
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops, a File  Not Found Exception occurred!");			
			e.printStackTrace();
		} catch (IOException e) {			
			System.out.println("Oops, an IOException occurred!");
			e.printStackTrace();
		}
				
		return newArray;
	}
	//=========================================================
	public static User[] fillUserArray() {
				
		String[] stringArray = null;
		User[] userArray = new User[4]; //4 registered users
		int j = 0;
		
		try {
			stringArray = convertFile();				
		} catch (IOException e) {
			System.out.println("Oops! An IOException has occurred.");
			e.printStackTrace();
		}
		//usernames at 0, 3, 6, 9 therefor jump 3 places at a time
		for (int i = 0; i < 12; i+=3)
		{	//username password name
			//while(j < 4) {
				UserService userService = new UserService();
				userArray[j] = userService.createUser(stringArray[i], stringArray[i+1], stringArray[i+2]);
				j+=1;
			//}			
		}			
	return userArray;			
	}
	//========================================================
}