package file_operate;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class JFileChooserDemo extends JFrame{
	public JTextArea text;
	
	public JFileChooserDemo() throws IOException
	  {
		setTitle("Demo");
	    setSize(400, 400); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    text = new JTextArea();
	    analyzePath(); // get Path from user and display info
	    add(new JScrollPane(text)); 
	    setVisible(true);
	  }
	 
	
	public void analyzePath() throws IOException {
		
		Path path = getChoosePath();
		
		if (Files.exists(path)) {
			StringBuilder s = new StringBuilder();
			s.append(path.toAbsolutePath() + "\n");
			s.append(path + "\n");
			s.append("name: " + path.getFileName() + "\n");
			s.append("size: " + Files.size(path) + "\n");
			s.append(Files.isDirectory(path) ? "Is a directory" : "Is not a directory" + "\n");
			s.append(path.isAbsolute() ? "Is Absolute path" : "Is not Absolute path" + "\n\n");
			
			if(Files.isDirectory(path)) {
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
				s.append("Directory content: " + "\n");
				for(Path name : directoryStream) {
					s.append(name + "\n");
				}
			}
			text.setText(s.toString());
			System.out.print(s);
		}
		else {
			JOptionPane.showMessageDialog(null,"The path does not existing");
		}	
		
	}
	
	public Path getChoosePath() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION) {
			System.exit(1);
		}
		
		return fileChooser.getSelectedFile().toPath();
	}
}
