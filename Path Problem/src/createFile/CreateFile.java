package createFile;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class CreateFile {
	
	private static Formatter output;
	public static void main(String[] args) {
		openFile();
		addRecord();
		closeFile();
	}
	
	public static void openFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = jfc.showSaveDialog(null);
		if(result != JFileChooser.CANCEL_OPTION) {
			try {
				output = new Formatter(jfc.getSelectedFile());
			}
			catch (SecurityException securityException)
		    {
		       System.err.println("Write permission denied. Terminating.");
		       System.exit(1); // terminate the program
		    }
			catch (FileNotFoundException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
				System.exit(1);
			}
		}
		
	}
	
	public static void addRecord() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input the data you want to store the first is your name, the second is your money");
		System.out.print("->");
		
		while(input.hasNext()) {
			try {
				output.format("%s %d%n",input.next(),input.nextInt());
			}
			catch (FormatterClosedException formatterClosedException)
	        {
	           System.err.println("Error writing to file. Terminating.");
	           break;
	        } 
	        catch (NoSuchElementException elementException)
	        {
	           System.err.println("Invalid input. Please try again.");
	           input.nextLine(); // discard input so user can try again
	        }
			System.out.print("->");
	 
		}
	}
	
	public static void closeFile() {
		if(output != null) {
			output.close();
		}
		
	}

}
