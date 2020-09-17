package file_operate;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.scene.shape.Path;

public class ReadFile {

	private static Scanner s;
	public static void main(String[] args) {
		openFile();
		readFile();
		closeFile();
	}
	
	private static void openFile() {
		try {
			s = new Scanner(Paths.get("created text.txt"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private static void readFile() {
		
		while(s.hasNext()) {
			System.out.println(s.next());
			System.out.println(s.next());
			System.out.println(s.nextLine());
		}
		
		//NoSuchElementException 
		//IllegalStateException
	}

	private static void closeFile() {
		if(s != null) {
			s.close();
		}
	}
}
