package postTool;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class StoreObject {

	private ObjectOutputStream output;
	public StoreObject(String fileName, String text, boolean status, Date time){
		openFile(fileName);
		addRecord(text,status,time);
		colseFile();
	}
	
	private void openFile(String fileName) {
		try {
			output = new ObjectOutputStream( Files.newOutputStream(Paths.get(fileName)) );
		} catch (IOException e) {
			System.out.println("openFile IOExcption");
		}	
	}
	
	private void addRecord(String text, boolean statue, Date time) {		
		try {
			//please use the object ypu want to serialize.
			PostSerializable postContent = new PostSerializable(text, statue, time);
			output.writeObject(postContent);
		} catch (IOException e) {
			System.out.println("addRecord IOExcption");
		}
		
	}
	
	private void colseFile() {
		if(output != null) {
			try {
				output.close();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}	
	}

	
}
