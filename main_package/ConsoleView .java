package main_package;

import java.io.File;
import java.util.Scanner;
import main_package.*;

public class ConsoleView {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String userInput;
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		//Starting system
		System.out.println("Program starting...");
		System.out.println("Creating folder...");
		controller.createFolder();
		//additional check for created folder
		if(new File(controller.folderPath).isDirectory()) {
			System.out.println("Folder succesfully created");
			System.out.println("Program started, type info for all commands");
		}else {
			System.out.println("Something went wrong...");
			System.exit(0);
		}
		//print all program commands
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("System comands:");

		System.out.println("-c  @name of file@ -- create file");
		System.out.println("-e  @name of file@ -- edit file");
		System.out.println("-d  @name of file@ -- delete file");
		System.out.println("-co @name of file@ -- copy from first file to second");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//start scanning input
		userInput = scanner.nextLine();
	    String[] command = userInput.split(" ");
	    //command for always working input
	    while(true) {
	    //choosing command	
	    switch(command[0]) {
	    case "-c":
	    	newFile createFile = new newFile(command[1], null);
	    	controller.createNewFile(createFile);
			System.out.println("file succesfully created");
	    	userInput = scanner.nextLine();
	    	break;
	    	
	    case "-e":
	    	newFile editFile = new newFile(command[1], command[2]);
	    	controller.editFile(editFile);
	    	controller.readFile(editFile);
	    	
	    	//outputing context of file
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    	for (String line :controller.linesAsArray) {
	            System.out.println(line);
	            }
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    	System.out.println("file succesfully edited");
	    	userInput = scanner.nextLine();
	    	break;
	    	
	    case "-d":
	    	newFile deleteFile = new newFile(command[1], null);
	    	controller.deleteFile(deleteFile);
	    	System.out.println("file succesfully deleted");
	    	userInput = scanner.nextLine();
	    	break;
	    
	    case "-co":
	    	newFile copiedFile = new newFile(command[1], null);
	    	newFile fileForCopy = new newFile(command[2], null);
	    	controller.copyFile(copiedFile, fileForCopy);
	    	controller.readFile(fileForCopy);
	    	//outputing context of file
	    	System.out.println("file succesfully copied");
	    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    	for (String line :controller.linesAsArray) {
	            System.out.println(line);
	            }
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    	userInput = scanner.nextLine();
	    	break;	
	    	
	    	}
	    }
	    

		
	}

}
