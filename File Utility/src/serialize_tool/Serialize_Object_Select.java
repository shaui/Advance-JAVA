package serialize_tool;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.swing.JFileChooser;

public class Serialize_Object_Select {
	private static ObjectOutputStream output;
	
	public Serialize_Object_Select() {
		serializeObject();
	}
	
	private void serializeObject() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = jfc.showSaveDialog(null);
		if(result != JFileChooser.CANCEL_OPTION) {
			Path path = Paths.get(jfc.getSelectedFile().getAbsolutePath());
			try {
				output = new ObjectOutputStream( Files.newOutputStream(path) ); //choose the Path
				PostSerializable postContent = new PostSerializable("Hellow World!", false, new Date()); //choose the Object
				output.writeObject(postContent); // output the Object
				output.close();
			} catch (IOException e) {
				System.out.println("openFile IOExcption");
			}
		}
		
		
	}
}
