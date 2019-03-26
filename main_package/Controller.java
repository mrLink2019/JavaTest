package main_package;

import java.io.*;
import java.util.Scanner;

public class Controller {
	
		static String folderLocation = System.getProperty("user.home").concat("\\Desktop\\");
		static String folderName = "FileProject";
		static String slash = "\\";
		String folderPath = folderLocation.concat(folderName);
		String filePath = folderPath.concat(slash);
		String line;	
	
	    public void createFolder() {    	
	    	File folder = new File(folderPath);
	    	folder.mkdir();
	    }
	    
	    public void createNewFile(newFile file) throws Exception {
	    	File newFile = new File(filePath +file.name.concat(".txt"));
	    	newFile.createNewFile();
	    }
	    
	    public void editFile(newFile file) throws Exception {
	    	File newFile = new File(filePath +file.name.concat(".txt"));
			FileWriter fileWriter = new FileWriter(newFile);
			fileWriter.write(file.context);
			fileWriter.flush();
			fileWriter.close();
	    }
	    
	    public void deleteFile(newFile file) {
	    	File newFile = new File(filePath +file.name.concat(".txt"));
	    	newFile.delete();	    	
	    }
	    
	    public void readFile(newFile file) throws Exception {
	    	File newFile = new File(filePath +file.name.concat(".txt"));
			FileReader fileReader = new FileReader(newFile); // поток который подключается к текстовому файлу
			BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
			
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line); 
			}
			bufferedReader.close(); 
	    }
}
