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
		//return instance of object
		return newUser;
	}	
	//========================================================
	public static void appInput() {
		
		//initialize objects
		String[] userStringArray = new String[12]; //set to 4 since 4 * 3 = 12 lines
		String[] sourceArray = new String[4]; //set to 4 since data.txt has 4 lines
		String[] splitStringArray = new String[12];		
		User[] userArray = new User[12];
		User user = new User();
		UserService userService = new UserService();		
		Scanner inputScanner = new Scanner(System.in);		
		BufferedReader fileReader = null;
		int k = 0;
		
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
			String textLine = "";				
			
			//read the file until an empty (null) line is reached into stringArray
			while ((textLine = fileReader.readLine()) != null) {							
				//insert data into the array
				sourceArray[i] = textLine.toString();
				//feedback for my troubleshooting
				System.out.println("Line at index " + i + ": " + sourceArray[i].toString());				
				i++;
				}				
			
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();			
		}  catch(IOException e){
			System.out.println("Oops, there was an IO exception");
		}
			finally {	
					try {
							System.out.println("Closing file reader");
							fileReader.close();
					} catch (IOException e){
							System.out.println("Oops! An IOException has occurred");
							e.printStackTrace();
					}
		}		

		//System.out.println("userArray Index Value Check: " + userArray);
		//input users into the array after parsing					
		String[] newArray = parseText(sourceArray);		
		
		//somewhere load up an array of users userArray[i] = userService.createUser(null, null, null);
		
		//send user input for validation
		//appInputCheck(usernameInput, passwordInput); 
	}	
	//========================================================
	public static String[] parseText(String[] inputs) {
		//this method will move elements from all being on the same line and split them onto their own		
		String[] goodArray = new String[12];
		int k = 0;
		
				for (String input: inputs) {
					String[] badArray = input.split(",");
					
					for (int i = 0; i < goodArray.length; i++) {
						int j = 0;
						while (j < badArray.length && k < goodArray.length){
							goodArray[k] = badArray[j];	
							j++;
							k++;
						}
					}
										
				}
				
				for (String textValue : goodArray) {
					System.out.println("ForEachLoop Output:\n " + textValue);
					System.out.println("Value at Array Index " + goodArray[3]);
				}												

			return goodArray;
		}				
	//========================================================
	public static void appInputCheck(String username, String password) {
		//initialize objects
		
		//for each loop? Maybe do it in the try block instead
				
		//read data from data.txt
		//insert it into an array
		//check user input against array
		
			
			System.out.println("END");
	}
	
	public static void testMethod() {
		
		String[] newArray = new String[12];
		String[] splitArray = new String[12];
		
		File textFile = new File("data.txt");
		Scanner fileScanner = new Scanner(System.in);
		int k = 0;
		
		try {
			fileScanner = new Scanner(textFile);
			
			while(fileScanner.hasNextLine()) {
			
				String initialText = fileScanner.nextLine();
				splitArray = initialText.split(",");
				
				for (int i = 0; i < newArray.length; i++) {
					int j = 0;
					//System.out.println(k);
					
					//add the 3 elements into a new array
					while (j < splitArray.length && k < newArray.length){
						newArray[k] = splitArray[j];	
						j++;
						k++;
					}
				}
									
				for (String splitText : splitArray) {
					 System.out.println("ForEachLoop Output:\n " + splitText);
					 newArray = splitArray;
					//System.out.println("Value at Array Index " + lineData[3]);
				}												
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops, a File  Not Found Exception Occurred!");
			
			fileScanner.close();
			e.printStackTrace();
		}	//System.out.println("StringArray: " + stringArray[3]);		
		
	}
		
}