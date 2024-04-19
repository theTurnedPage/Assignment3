package com.coderscampus.unit5assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		System.out.println("User Created");
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
		inputScanner.close();
		//================END input from the USER================
		
		appInputCheck(usernameInput, passwordInput);
							
		//somewhere load up an array of users userArray[i] = userService.createUser(null, null, null);		
	}			
	//========================================================
	public static void appInputCheck(String username, String password) {
		//initialize objects
		String realName = "";			


		//check user input against array of Users
		
			
		//give feedback against login creds				
			System.out.println("Welcome: " + realName);
			
			
			System.out.println("Invalid login, please try again.");
	}
	//=========================================================
	public static String[] convertFile() throws IOException {
		//create objects
		String[] newArray = new String[12];
		String[] splitArray = new String[12];
		BufferedReader fileReader = null;
		int k = 0;
		
		//begin reading the data.txt file, then split, and return
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			String aLine = "";
			while ((aLine = fileReader.readLine()) != null) {				
										 				
				for (int i = 0; i < 4; i++) {
					int j = 0;
					//System.out.println(k); this shows increments of 3 for k, while loop
					//runs up to length of splitArray, which is 3
					//3 * 4 == 12, matching length of newArray
					
					aLine = fileReader.readLine();
					newArray = aLine.split(",");
					
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
		for (int i = 0; i < 9; i+=3)
		{	//username password name
			while(j < 4) {
				UserService userService = new UserService();
				userArray[j] = userService.createUser(stringArray[i], stringArray[i+1], stringArray[i+2]);
				j+=1;
			}			
		}			
	return userArray;			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//========================================================
	public static void testMethod() {
		
		String[] newArray = new String[12];
		String[] splitArray = new String[12];
		
		File textFile = new File("data.txt");
		Scanner fileScanner = new Scanner(System.in);
		int k = 0;
		
		try {
			fileScanner = new Scanner(textFile);			
			while(fileScanner.hasNextLine()) {
						
				for (int i = 0; i < 4; i++) {
					int j = 0;
					//System.out.println(k); this shows increments of 3 for k, while loop
					//runs up to length of splitArray, which is 3
					//3 * 4 == 12, matching length of newArray
					
					String initialText = fileScanner.nextLine();
					splitArray = initialText.split(",");
					
					//add the 3 elements into a newArray from splitArray 
					while (j < splitArray.length && k < newArray.length){
						newArray[k] = splitArray[j];	
						j++;
						k++;
					}
				}
									
				for (String splitText : newArray) {
									
					System.out.println(" ForEachLoop Output:\n " + splitText);
					 
					//this sysout goes out of bounds whenever newArray = splitArray
					//and whenever I go past index 2 for splitArray (e.g. 3)
					//System.out.println("Value at Array Index " + splitArray[3]);
				}												
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops, a File  Not Found Exception Occurred!");
			
			fileScanner.close();
			e.printStackTrace();
		}	
		
	}
		
}