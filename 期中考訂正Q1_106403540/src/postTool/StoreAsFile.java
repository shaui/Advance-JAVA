package postTool;

import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class StoreAsFile {

	private Formatter output;
	private String text = "";
	public StoreAsFile(String text) {
		this.text = text;
		openFile();
		
	}
	
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int selectResult = chooser.showSaveDialog(null);
		
		if(selectResult != JFileChooser.CANCEL_OPTION) {
			try {
				String path = chooser.getSelectedFile().getPath();
				//File newFile = new File(path); //if the file isn't existing, we should create one otherwise it will have the FileNotFoundException
				output = new Formatter(path);
				addRecord(text);
				colseFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			;
		}
	}
	
	private void addRecord(String text) {
		String[] content = text.split("\n"); //set the each line of text to a String[]
		for(int i=0; i<content.length; i++) {
			output.format(content[i] + "%n"); //add the content to the file
		}
		
	}
	
	private void colseFile() {
		if(output != null) {
			output.close();
		}	
	}

	
}
