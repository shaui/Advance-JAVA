package postTool;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Serialize_Object_Direct {
	private static ObjectOutputStream output;
	
	public Serialize_Object_Direct() {
		serializeObject();
	}
	
	private void serializeObject() {
		try {
			output = new ObjectOutputStream( Files.newOutputStream(Paths.get("HW3 Announcement System") ) ); //choose the Path
			PostSerializable postContent = new PostSerializable("HW3 Announcement System", false, new Date()); //choose the Object
			output.writeObject(postContent); // output the Object
			output.close();
		} catch (IOException e) {
			System.out.println("openFile IOExcption");
		}
	}
}
