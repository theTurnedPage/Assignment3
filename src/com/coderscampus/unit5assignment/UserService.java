package com.coderscampus.unit5assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {
		
	public static void appUsernamePrompt() {
		System.out.println("---------");
		System.out.println("Username:\n >");		
	}
	
	public static void appPasswordPrompt() {
		System.out.println("---------");
		System.out.println("Password:\n >");		
	}

	public User createUser (String username, String password, String name) {
		//create new instance of object 
		User newUser = new User();
		//use setters to set values for attributes of object instance
		newUser.setUsername(username);
		newUser.setPassword(password);	 
		newUser.setName(name);
		//return instance of object
		return newUser;
	}	
	
	public static void appInput() {
		
		//initialize objects
		String[] stringArray = new String[4]; //set to 4 since data.txt has 4 lines
		System.out.println("string array length: " + stringArray.length);
		User[] userArray = new User[12]; //take as string then convert to object User
		User user = new User();
		Scanner inputScanner = new Scanner(System.in);		
		BufferedReader fileReader = null;
		UserService userService = new UserService();

		
		//=================BEGIN input from USER====================
		//show prompt for user's input, assign value to variables
		appUsernamePrompt();
		String usernameInput = inputScanner.nextLine();				
		appPasswordPrompt();
		String passwordInput = inputScanner.nextLine();
		//close scanner, pass the input into other method for validation
		inputScanner.close();
		//================END input from the USER================
				
				
		
		
		//read file to String Array				
		try { //read the file
			fileReader = new BufferedReader(new FileReader("data.txt")); //had to create data.txt outside src folder 				
			//start at index 0 for the array
			int i = 0;
			String line = "";
			
			//read the file until an empty (null) line is reached
			while ((line = fileReader.readLine()) != null) {							
				//insert data into the array
				stringArray[i] = line.toString();				
				System.out.println("Line at index " + i + ": " + stringArray[i].toString());				
				i++;								
			}								
			System.out.println("string array length: " + stringArray.length);
			 	
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();			
		}  catch(IOException e){
			System.out.println("Oops, there was an IO exception");
		}
			finally {
		
			try{
				System.out.println("Closing file reader");
				fileReader.close();
			} catch (IOException e){
				System.out.println("Oops! An IOException has occurred");
				e.printStackTrace();
			}
		}		
		
		System.out.println("string array length: " + stringArray.length);
		//input users into the array after parsing					
		String[] newArray = parseText(stringArray);
		System.out.println(newArray.toString());
		
		//userArray[1] = userService.createUser(null, null, null);
		//appInputCheck(usernameInput, passwordInput);
	}	
	
	public static String[] parseText(String[] inputs) {
		//this method will move elements from all being on the same line and split them onto their own
		//String[] userArray = new String [inputs.length];	
		
		String[] userArray = inputs.clone();
		
		System.out.println("inputs length: " + inputs.length);
		System.out.println("userArray length: " + userArray.length);
		
		
			for (String input : inputs) {
				System.out.println("test");
				//System.out.println(input);
				//1,2,3,4,5, -> [0]="1". [1]="2", etc.
				String[] splitArray = input.split(",");
				
				for (String splits : splitArray) {
					userArray = splitArray;
				}
				
			}			
			
			
			for (int i = 0; i < userArray.length; i++) {
				System.out.println(userArray[i]);
			}
			
		 


			//System.out.println(userArray[i]);			
			//userArray[i] = splitArray[i];
			
			//System.out.println("split string at index: " + i + " " + splitString[i].toString());
			//userArray[i] = splitString[i]; 						
			
			//for (String data: userArray) {
				//System.out.println("for loop 2 userArray: " + data);
				
			//}
			
		
		System.out.println("userArray length: " + userArray.length);
		int i = 0;
		while(i < userArray.length) {
			
			if (i == userArray.length) {
				break;
			}
			
			System.out.println("userArray at index: " + i + " " +  userArray[i]);// + " " + userArray[i].toString()); //show data we got, success!
			i++;

		}
		
		
		return userArray;
	}
	
	public static void appInputCheck(String username, String password) {
		//initialize objects
		String[] realUsers = new String[4]; //set to 4 since data.txt has 4 lines
		User[] realUsers2 = new User[4]; //take as string then convert to object User
		
		BufferedReader fileReader = null;
		UserService userService = new UserService();
		
		//for each loop? Maybe do it in the try block instead
		
		
		
		
		//read data from data.txt
		//insert it into an array
		//check user input against array


			
			System.out.println("END");
		
	}
		
	

}