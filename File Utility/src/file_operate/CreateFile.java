package file_operate;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class CreateFile{
	
	private Formatter output;
	private String fileName;

	public CreateFile() throws IOException{
	    openFile();
		addRecord();
		closeFile(); 
	}
	
	public void openFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    int result = jfc.showSaveDialog(null);
	    System.out.println(jfc.getSelectedFile());
	    System.out.println(jfc.getSelectedFile().getPath());
	    
	    File newFile = new File(jfc.getSelectedFile().getPath());
		
		if(result != JFileChooser.CANCEL_OPTION) {
			try {
				output = new Formatter(jfc.getSelectedFile().getPath()); 
			}
			catch (SecurityException securityException)
		    {
		       System.err.println("Write permission denied. Terminating.");
		       System.exit(1); // terminate the program
		    } catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void addRecord() {
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
	
	public void closeFile() {
		if(output != null) {
			output.close();
		}
		
	}

}
