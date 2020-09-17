package serialize_tool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read_Object_Direct {
	private static ObjectInputStream input;
	
	public Read_Object_Direct() {
		readObject();
	}
	
	private void readObject() {
		try {
			input = new ObjectInputStream( Files.newInputStream(Paths.get("")) ); //choose the path
			PostSerializable postContent = (PostSerializable) input.readObject(); //choose the Object
			input.close();
		} catch (IOException e) {
			System.out.println("IOExcption");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		}
	}
}
