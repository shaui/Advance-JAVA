package file_operate;

import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OuputFile_SelectPath {
	private Formatter f;
	
	public OuputFile_SelectPath() {
		outputFile();
	}
	private void outputFile() {
		JFileChooser js = new JFileChooser();
		js.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = js.showSaveDialog(null);
		if(result != JOptionPane.CANCEL_OPTION) {
			try {
				String path = js.getSelectedFile().getPath();
				f = new Formatter(path);
				f.format(""); //output content
				f.close();
			} catch (FileNotFoundException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
		}
	}
}
