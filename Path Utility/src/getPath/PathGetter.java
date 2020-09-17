package getPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathGetter {

	public static void main(String[] args) throws IOException {
		
		String input = "1";
		Scanner s = new Scanner(System.in);
		while(input != "0") {
			System.out.println("Enter a path and enter 0 to exit");
			input = s.nextLine();
			Path path = Paths.get(input);
			
			if (Files.exists(path)) {
				System.out.println(path.toAbsolutePath());
				System.out.println(path);
				System.out.println("name: " + path.getFileName());
				System.out.println("size: " + Files.size(path));
				System.out.println(Files.isDirectory(path) ? "Is a directory" : "Is not a directory");
				System.out.println(path.isAbsolute() ? "Is Absolute path" : "Is not Absolute path");
				System.out.println();
				
			}
			else {
				System.out.println("The path does not existing");
			}
			
			if(Files.isDirectory(path)) {
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
				System.out.println("Directory content: ");
				for(Path name : directoryStream) {
					System.out.println(name);
				}
				System.out.println();
			}
		}
			
			
		
		
	}

}
