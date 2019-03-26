package main_package;

import java.util.Scanner;
import main_package.*;

public class ConsoleView {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String userInput;
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		controller.createFolder();
	
		System.out.println("Program started");
		userInput = scanner.nextLine();
	    String[] command = userInput.split(" ");
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
	    	System.out.println("file succesfully edited");
	    	userInput = scanner.nextLine();
	    	break;
	    	
	    case "-d":
	    	newFile deleteFile = new newFile(command[1], null);
	    	controller.deleteFile(deleteFile);
	    	System.out.println("file succesfully deleted");
	    	userInput = scanner.nextLine();
	    	break;
	    	
	    }
	    

		
	}

}
