package file_operate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFile_Direct {
	private Scanner s;
	
	public ReadFile_Direct() {
		readFile();
	}
	
	private void readFile() {
		try {
			s = new Scanner(Paths.get("Output_Direct.txt")); //notice that the Scanner will use the parameter --> (Path or File)
			while(s.hasNext()) {
				System.out.println(s.nextLine());
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
