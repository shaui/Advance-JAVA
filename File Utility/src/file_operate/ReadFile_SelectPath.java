package file_operate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ReadFile_SelectPath {
	private Scanner s;
	
	public ReadFile_SelectPath() {
		readFile();
	}
	
	private void readFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = jfc.showOpenDialog(null);
		if(result != JFileChooser.CANCEL_OPTION) {
			File Path = jfc.getSelectedFile(); //use the file as the Path
			try {
				s = new Scanner(Path); //notice that the Scanner will use the parameter --> (Path or File)
				while(s.hasNext()) {
					System.out.println(s.nextLine());
				}
				s.close();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
	}
	
}
