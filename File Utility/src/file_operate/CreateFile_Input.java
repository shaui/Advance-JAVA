package file_operate;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFile_Input {
	private Formatter f;
	public CreateFile_Input() {
		openFile(); //assign where to store
		addRecord(); //format the content
		closeFile(); //close the file
	}
	
	public static void main(String[] args) {
		CreateFile_Input c = new CreateFile_Input();

	}
	
	private void openFile() {
		try {
			f = new Formatter("Easy_Create.txt");
		} catch (FileNotFoundException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	private void addRecord() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please input your name and money.");
		System.out.print("-->");
		while(s.hasNext()){
			f.format("%s %d\n",s.next(),s.nextInt());
			System.out.print("->");
		}
	}
	
	private void closeFile() {
		if(f != null) {
			f.close();
		}
	}

}
