package main_package;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
		static String folderLocation = System.getProperty("user.home").concat("\\Desktop\\");
		static String folderName = "FileProject";
		static String slash = "\\";
		String folderPath = folderLocation.concat(folderName);
		String filePath = folderPath.concat(slash);
		String line;	
		String notes;
		String [] linesAsArray;
	
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
			
	        List<String> lines = new ArrayList<String>();
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        linesAsArray = lines.toArray(new String[lines.size()]);
			bufferedReader.close(); 
	    }
	    
	    public void copyFile(newFile copiedFile, newFile fileForCopy) throws Exception {
	    	File copiedObject = new File(filePath +copiedFile.name.concat(".txt"));
	    	File objectForCopy = new File(filePath +fileForCopy.name.concat(".txt"));
	    	FileReader fileReader = new FileReader(copiedObject);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter(objectForCopy);
			
	        List<String> lines = new ArrayList<String>();
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        linesAsArray = lines.toArray(new String[lines.size()]);
	        
	        for(int i = 0;i<linesAsArray.length;i++) {
	        	line = linesAsArray[i];
	        	fileWriter.write(line);
	        }
			bufferedReader.close(); 
			fileWriter.flush();
			fileWriter.close();    	
	    }
}
