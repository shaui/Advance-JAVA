package serialize_tool;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class Create {

	private static ObjectOutputStream output;
	public static void main(String[] args) {
		openFile();
		addRecord();
		colseFile();
	}
	
	private static void openFile() {
		 try 
	      {
	         output = new ObjectOutputStream(
	            Files.newOutputStream(Paths.get("card.ser")));
	      }
	      catch (IOException ioException)
	      {
	         System.err.println("Error opening file. Terminating.");
	         System.exit(1); // terminate the program
	      } 
		
	}
	
	private static void addRecord() {
	            // serialize record object into file
				try {
	            	 // create new record; this example assumes valid input
		        	Cards c = new Cards(3,1);
					output.writeObject(c);
				} catch (IOException e) {
					// TODO 自動產生的 catch 區塊
					e.printStackTrace();
				} 
	}
	
	
	private static void colseFile() {
		if(output != null) {
			try {
				output.close();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}	
	}

	
}
