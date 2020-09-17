package file_operate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Read_SelectedPath {
	
	Scanner s;
	
	public Read_SelectedPath() {
		openFile();
		readFile();
		closeFile();
	}
	
	public static void main(String[] args) {
		Read_SelectedPath r = new Read_SelectedPath();

	}
	
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = chooser.showOpenDialog(null);
		if(result != JFileChooser.CANCEL_OPTION) {
			try {
				if(chooser.getSelectedFile().isDirectory()) {
					JOptionPane.showMessageDialog(null,"Please choose a file not a directory.");
					System.exit(1);
				}
				else {
					s = new Scanner(chooser.getSelectedFile());
				}
			} catch (FileNotFoundException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
		
	}
	
	private void readFile() {
		while(s.hasNext()) {
			System.out.println(s.nextLine());
		}
	}
	
	private void closeFile() {
		if(s != null) {
			s.close();
		}
	}

}
