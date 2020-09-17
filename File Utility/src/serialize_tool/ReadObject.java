package serialize_tool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

public class ReadObject {
	
	private static ObjectInputStream input;
	public static void main(String[] args) {
		openFile();
		readFile();
		closeFile();
	}
	
	private static void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = chooser.showOpenDialog(null);
		
		if(result != JFileChooser.CANCEL_OPTION) {
			String path = chooser.getSelectedFile().getAbsolutePath();
			try {
				input = new ObjectInputStream( Files.newInputStream(Paths.get(path) ) );
			} catch (IOException e) {
				System.out.println("openFile IOExcption");
			}
		}
	}

	private static void readFile() {
		try {
			//the Object you want to read
			PostSerializable postContent = (PostSerializable) input.readObject();
			System.out.println(postContent.getEditTime());
			System.out.println(postContent.getContent());
			System.out.println(postContent.getIsLike());
		} catch (ClassNotFoundException e) {
			System.out.println("readFile ClassNotFoundException");
		} catch (IOException e) {
			System.out.println("readFile IOExcption");
		}

	}
	
	private static void closeFile() {
		if(input != null) {
			try {
				input.close();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
	}
	
}
