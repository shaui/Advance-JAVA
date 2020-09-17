package post_html;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ReadFile {
	
	private Scanner input;
	private String text = "";
	public ReadFile() {
		openFile();
		readFile();
		closeFile();
	}
	
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int selectResult = chooser.showOpenDialog(null);
		
		if(selectResult == JFileChooser.APPROVE_OPTION) {
			try {
				input = new Scanner(chooser.getSelectedFile());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		else {
			System.exit(1);
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
