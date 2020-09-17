package serialize_tool;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.swing.JFileChooser;
public class CreateObject {

	private static ObjectOutputStream output;
	public static void main(String[] args) {
		openFile();
		addRecord();
		colseFile();
	}
	
	private static void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int selectResult = chooser.showSaveDialog(null);
		
		if(selectResult != JFileChooser.CANCEL_OPTION) {
			Path path = Paths.get(chooser.getSelectedFile().getAbsolutePath());
			try {
				output = new ObjectOutputStream( Files.newOutputStream(path) );
			} catch (IOException e) {
				System.out.println("openFile IOExcption");
			}
		}
		
	}
	
	private static void addRecord() {
		
		try {
			//please use the object ypu want to serialize.
			PostSerializable postContent = new PostSerializable("Hellow World!", false, new Date());
			output.writeObject(postContent);
		} catch (IOException e) {
			System.out.println("addRecord IOExcption");
		}
		
	}
	
	private static void colseFile() {
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
