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
		String[] stringArray2 = new String[12];
		
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
				
				
		
		String[] stringArray3 = new String[12];
		//read file to String Array				
		try { //read the file
			fileReader = new BufferedReader(new FileReader("data.txt")); //had to create data.txt outside src folder 				
			//start at index 0 for the array
			int i = 0;
			String textLine = "";
			
			//read the file until an empty (null) line is reached into stringArray
			while ((textLine = fileReader.readLine()) != null) {							
				//insert data into the array
				stringArray[i] = textLine.toString();
				//feedback for my troubleshooting
				System.out.println("Line at index " + i + ": " + stringArray[i].toString());				
				i++;
				}
			
			//modify the output from data.txt and put it into an array, with delimiter ","
			for (String textLine2: stringArray) {
				
				stringArray2 = textLine2.split(",");
				//System.out.println(" textLine2: "+" "+textLine2);
				for (int i2 = 0; i2 < stringArray2.length; i2++) {
					 
					 for (String textLine4: stringArray2) {
						 stringArray3[i2] = textLine4;	 
					 }
				}
				
				
				for (String textLine3: stringArray2) {					
					System.out.println(" textLine3 and stringArray2: "+" "+textLine3);
					
				}							
				

			}					
			//feedback for my troubleshooting
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
		System.out.println("stringArray length: " + stringArray.length); 				//feedback for my troubleshooting
		System.out.println("stringArray2 length: " + stringArray2.length);
		System.out.println("stringArray3 length: " + stringArray3.length);
		System.out.println("SA3 Index Value Check: " + stringArray3[1]);
		//input users into the array after parsing					
		//String[] newArray = parseText(stringArray);		
		
		//somewhere load up an array of users userArray[i] = userService.createUser(null, null, null);
		
		//send user input for validation
		//appInputCheck(usernameInput, passwordInput); 
	}	
	
	public static String[] parseText(String[] inputs) {
		//this method will move elements from all being on the same line and split them onto their own
		String[] stringArray = null;	
		
		//String[] userArray = inputs.clone();		
		
		//System.out.println("inputs length: " + inputs.length); 				//feedback for my troubleshooting
		//System.out.println("userArray length: " + userArray.length);				//feedback for my troubleshooting
		//modify the output from data.txt and put it into an array, with delimiter ","
		for (String textLine2: inputs) {
			System.out.println(" textLine2: "+" "+textLine2);
			stringArray = textLine2.split(",");
			
			for (String textLine3: stringArray) {
				System.out.println(" textLine3: "+" "+textLine3);
			}							

		}		
		
			for (String input : inputs) {
				System.out.println("test");

				String[] splitArray = input.split(",");
				
				for (String splits : splitArray) {
					
				}
				
			}			
			
			//feedback for my troubleshooting
			//for (int i = 0; i < userArray.length; i++) {
//				System.out.println("userArray contents: " + userArray[i]);
			//}

			
		

			return stringArray;
		}				
	
	public static void appInputCheck(String username, String password) {
		//initialize objects

		
		//for each loop? Maybe do it in the try block instead
		
		
		
		
		//read data from data.txt
		//insert it into an array
		//check user input against array


			
			System.out.println("END");
		
	}
		
	

}