package main_package;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
		
		//searshing home directory
		static String folderLocation = System.getProperty("user.home").concat("\\Desktop\\");
		static String folderName = "FileProject";
		static String slash = "\\";
		String folderPath = folderLocation.concat(folderName);
		String filePath = folderPath.concat(slash);
		String line;	
		String notes;
		String [] linesAsArray;
	
	    public void createFolder() { 
	    	//creating folder
	    	File folder = new File(folderPath);
	    	folder.mkdir();
	    }
	    
	    public void createNewFile(newFile file) throws Exception {
	    	//check for directory
	    	if(new File(folderPath).isDirectory()) {
	    	//creating new file
	    	File newFile = new File(filePath +file.name.concat(".txt"));
	    	newFile.createNewFile();
	    	}
	    }
	    
	    public void editFile(newFile file) throws Exception {
	    	//check for directory and created file
	    	if(new File(folderPath).isDirectory() & new File(filePath +file.name.concat(".txt")).isFile()) {
	    	File newFile = new File(filePath +file.name.concat(".txt"));
	    	//writing file
			FileWriter fileWriter = new FileWriter(newFile);
			fileWriter.write(file.context);
			//closing fileWriter
			fileWriter.flush();
			fileWriter.close();
	    	}
	    }
	    
	    public void deleteFile(newFile file) {
	    	//check for directory and created file
	    	if(new File(folderPath).isDirectory() & new File(filePath +file.name.concat(".txt")).isFile()) {
	    	//deleting file
	    	File newFile = new File(filePath +file.name.concat(".txt"));
	    	newFile.delete();	
	    	}
	    }
	    
	    public void readFile(newFile file) throws Exception {
	    	//check for directory and created file
	    	if(new File(folderPath).isDirectory() & new File(filePath +file.name.concat(".txt")).isFile()) {
	    	File newFile = new File(filePath +file.name.concat(".txt"));
			FileReader fileReader = new FileReader(newFile); // поток который подключается к текстовому файлу
			BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
			//wrining context of file to arrayList
	        List<String> lines = new ArrayList<String>();
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        //converting to array
	        linesAsArray = lines.toArray(new String[lines.size()]);
	        //closing bufferedReader and fileReader
			bufferedReader.close(); 
			fileReader.close();
	    	}
	    }
	    //copying of files
	    public void copyFile(newFile copiedFile, newFile fileForCopy) throws Exception {
	    	//check for directory and created files
	    	if(new File(folderPath).isDirectory() & new File(filePath +copiedFile.name.concat(".txt")).isFile()
	    			& new File(filePath +fileForCopy.name.concat(".txt")).isFile()) {
	    		//creating file objects
	    	File copiedObject = new File(filePath +copiedFile.name.concat(".txt"));
	    	File objectForCopy = new File(filePath +fileForCopy.name.concat(".txt"));
	    	FileReader fileReader = new FileReader(copiedObject);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter(objectForCopy);
			//wrining context of file to arrayList
	        List<String> lines = new ArrayList<String>();
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        //converting to array
	        linesAsArray = lines.toArray(new String[lines.size()]);
	        //copying context from first file to second
	        for(int i = 0;i<linesAsArray.length;i++) {
	        	line = linesAsArray[i];
	        	fileWriter.write(line);
	        }
	        //closing
			bufferedReader.close(); 
			fileWriter.flush();
			fileWriter.close();
	    	}
	    }
}
