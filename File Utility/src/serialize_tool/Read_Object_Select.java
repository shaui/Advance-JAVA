package serialize_tool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


import javax.swing.JFileChooser;

public class Read_Object_Select {
	private static ObjectInputStream input;
	
	public Read_Object_Select() {
		readObject();
	}
	
	private void readObject() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = jfc.showOpenDialog(null);
		if(result != JFileChooser.CANCEL_OPTION) {
			String path = jfc.getSelectedFile().getAbsolutePath();
			try {
				input = new ObjectInputStream( Files.newInputStream(Paths.get(path)) ); //choose the path
				PostSerializable postContent = (PostSerializable) input.readObject(); //choose the Object
				input.close();
			} catch (IOException e) {
				System.out.println("IOExcption");
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException");
			}
		}
		
	}
}
