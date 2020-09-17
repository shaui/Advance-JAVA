package postTool;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ReadFile {
	
	private Scanner input;
	private String text = "";
	public ReadFile() {
		openFile();
	}
	
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int selectResult = chooser.showOpenDialog(null);
		
		if(selectResult == JFileChooser.APPROVE_OPTION) {
			try {
				input = new Scanner(chooser.getSelectedFile());
				readFile();
				closeFile();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		else {
			;
		}
	}

	private void readFile() {
		while(input.hasNext()) {
			text += input.nextLine() + "\n";
		}
	}
	
	private void closeFile() {
		if(input != null) {
			input.close();
		}
	}
	
	public String getText() {
		return text;
	}
	
}
